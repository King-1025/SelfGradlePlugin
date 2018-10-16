package king.tool;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlException;

import java.util.Map;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class YamlTool{

   public static Object read(String config,String space,String tag,Class<?> clazz) throws YamlException,FileNotFoundException{
     YamlReader reader = new YamlReader(new FileReader(config));
    reader.getConfig().setClassTag(tag,clazz);
    Map data=(Map)reader.read();
    if(data!=null) return data.get(space);
    else return null;
   /*Object data=null;
    while(true){
    	data=reader.read();
    	if (data!=null){
           if(lm==null) lm=new ArrayList<>();
           else lm.add(data);
        }else{
           break;
        }
    }
    return lm;*/
  }

}
