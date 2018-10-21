package king.model;

import java.util.List;
import java.util.ArrayList;

import king.model.Parser;
import king.model.Space;

public class SpaceHandler implements Parser{
    private static SpaceHandler instance;
    private List<String> functions;
    public String genCrawlFunction(Space space){
        if(functions==null){
           functions=new ArrayList<>();
        }
        String content="function "+space.getName()+"()\n{";
        content+="\n  echo space:"+space.getName();
        content+="\n  echo site:"+space.getSite();
        content+="\n  echo type:"+space.getType();
        
        content+="\n}";
        functions.add(space.getName());
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
