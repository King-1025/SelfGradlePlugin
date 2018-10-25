package king.model;

import java.util.List;
import java.util.ArrayList;

import king.model.Parser;
import king.model.Space;
import king.exception.ParseException;
import king.model.R;
import king.tool.TaskTool;
import king.tool.Log;

public class SpaceHandler implements Parser{
    private static SpaceHandler instance;
    private List<String> functions;
    private List<String> track;

    public String genCrawlFunction(Space space){
        if(functions==null){
           functions=new ArrayList<>();
        }
        if(track==null){
           track=new ArrayList<>();
        }
        String funName=space.getName();
        String content="function "+funName+"()\n{";
        String record="$ROOT/."+funName+R.def.CRAWL_RECORD_SUBFIX;
        content+="\n"+TaskTool.E(1,2)+"log i \""+funName+" start...\"";
        content+="\n"+TaskTool.E(1,2)+"record_"+funName+"="+record;
        content+="\n"+TaskTool.E(1,2)+"init_record ${record_"+funName+"}";
        String site=space.getSite();
        String type=space.getType();
        Object[] structure=space.getStructure().toArray(); 
        int size=structure.length;
        Log.q("genCrawlFunction()","size:"+size);
        Dimension dim=null;
        String rule=null;
        String emp=null;
        for(int i=0;i<size;i++){
          dim=(Dimension)structure[i];
          if(i==0)content+=handleStart(site,type,dim);
          emp="\n"+TaskTool.E(i+3,1);
          content+=emp+"for i"+i+" in ${"+getVarName(i,dim)+"}; do";
          emp+=" ";
          content+=emp+"read -u 6";
          content+=emp+"{";
          content+=emp+"data=$(mktemp -u)";
          content+=emp+"log i \"fetch ${i"+i+"}\"";
          content+=emp+"fetch \"${data}\" \"${i"+i+"}\" \"${i"+i+"}\"";
          content+=emp+"if [ $? != 0 ]||[ ! -e ${data} ];then continue; fi";
          content+=handleSave(emp,dim.getSave(),funName);
          rule=dim.getRule();
          if(!TaskTool.isNull(rule)&&(i+1<size)){
            dim=(Dimension)structure[i+1];
            content+=emp+"declare -a "+getVarName(i+1,dim)+"=$("+rule+")";
          }else{
            if(i+1==size){
              content+=emp+"plus_record TOTAL 1 ${record_"+funName+"}";
            }else{
              throw ParseException.notFoundRule(dim.getName());    
            }
          }
          content+=emp+"rm ${data} > /dev/null 2>&1";
          track.add(emp+"echo >&6"+emp+"} &"+emp+"done"+emp+"wait");
        }
        int tsize=track.size()-1;
        for(int i=tsize;i>=0;i--){
           content+=track.get(i);
        }
        track=null;
        content+="\n"+TaskTool.E(1,2)+"may_fix_html \""+funName+"\"";
        content+="\n"+TaskTool.E(1,2)+"log i \""+funName+" done!\"";
        content+="\n}";
        functions.add(funName);
        return content;
    }

    private String getVarName(int index,Dimension d){
        return maybeUse(d.getName(),R.def.MISSING_NAME_PREFIX+d.hashCode()+index);
    }

    private String maybeUse(String src,String def){
        if(TaskTool.isNull(src))return def;
        else return src;
    }

    private String handleSave(String emp,List save,String funName){
        String content="";
        if(save!=null){
          Rule rule=null;
          String tag=null;
          content+=emp+"local list=$(mktemp -u)";
          for(Object obj:save){
            rule=(Rule)obj;
            tag=rule.getTag();
            if(!TaskTool.isNull(tag)){
              content+=emp+"local "+tag+"=$("+rule.getAction()+")";
              content+=emp+"is_null \""+tag+"\" \"${"+tag+"}\" $(read_record SAVE ${record_"+funName+"})";
              content+=emp+"if [ $? -eq 0 ]; then echo \""+tag+"*"+rule.getType()+"*${"+tag+"}\" >> ${list}; fi";
            }
          }
          content+=emp+"save ${list} ${record_"+funName+"} \""+funName+"\"";
          content+=emp+"rm -rf ${list} > /dev/null 2>&1";
        }
        return content;
    }

    private String handleStart(String site,String type,Dimension dim){
      String content="\n"+TaskTool.E(1,2);
      String var=getVarName(0,dim);
      if(type.equals(Space.TYPE_SINGLE)){
        content+="declare -a "+var+"=(\""+site+"\")";
      }else if(type.equals(Space.TYPE_RANGE)){
        content+="for((index=${RANGE_START};index<=${RANGE_END};index++));do";
        content+="\n"+TaskTool.E(3,1)+"declare -a "+var+"=(\""+site+"${index}\")";
        track.add("\n"+TaskTool.E(1,2)+"done");
      }else{
         throw ParseException.notFoundType(type);
      }
      return content;
    }
  
    public List<String> listFunctionName(){
           List<String> tmp=functions;
           functions=null;  
           return tmp;
    }  

    public static SpaceHandler getInstance(){
       if(instance==null){
         instance=new SpaceHandler();
      }
      return instance;
    }
}
