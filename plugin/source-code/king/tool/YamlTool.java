package king.tool;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlException;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.io.FileReader;
import java.io.FileNotFoundException;

import king.model.Space;
import king.model.Dimension;
import king.model.Rule;
import king.model.R;
import king.tool.Log;

public class YamlTool{
  
   public static Object read(String config,Map<String,Class<?>> tag) throws YamlException,FileNotFoundException{
     YamlReader reader = new YamlReader(new FileReader(config));
    if(tag!=null){
      for(Map.Entry<String,Class<?>>entry:tag.entrySet()){ 
         reader.getConfig().setClassTag(entry.getKey(),entry.getValue());
      }
    }
    return reader.read();
  }

   private static Map<String,Class<?>> getClassTags(){
      Map<String,Class<?>>tags=new HashMap<>();
      tags.put(R.def.DIMENSION_YAML_TAG,Dimension.class);
      tags.put(R.def.RULE_YAML_TAG,Rule.class);
      return tags;
  }

  public static boolean configure(Space space){
      if(space!=null){
         try{
           Map map=(Map)read(space.getConfig(),getClassTags());
           String site=(String)map.get(R.def.SPACE_SITE);
           String type=(String)map.get(R.def.SPACE_TYPE);
           List structure=(List)map.get(space.getName());
           if(site!=null){
             space.setSite(site);
             if(type!=null){
               space.setType(type);
               if(structure!=null){
                 space.setStructure(structure);
                 return true;
               }else{
                 Log.q("YamlTool.Configure()","structure:"+space.getName()+" is empty."+"Please check it carefully.");
               }
           }else{
               Log.q("YamlTool.Configure()","space:"+space.getName()+" of type is empty!");
           }
         }else{
               Log.q("YamlTool.Configure()","space:"+space.getName()+" of site is empty!");
         }
        } catch(FileNotFoundException e){
           Log.e("YamlTool.configure()",e.toString());
        } catch(YamlException e){
           Log.e("YamlTool.configure()",e.toString());
        }
      }
      return false;
  } 
}
