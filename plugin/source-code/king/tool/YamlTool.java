package king.tool;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlException;

import java.util.Map;
import java.io.FileReader;
import java.io.FileNotFoundException;

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

}
