package king.task;

import com.esotericsoftware.yamlbeans.YamlException; 
import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.FileNotFoundException;

import king.model.R;
import king.tool.YamlTool;
import king.extension.ShellSpiderExtension;
import king.model.Space;
import king.model.Spider;
import king.tool.Log;
import king.model.Dimension;
import king.exception.GrowException;
import king.tool.TaskTool;
import king.model.Rule;

public class GrowTask extends SpiderTask{
  
  @Inject
  public GrowTask(Project project,ShellSpiderExtension extension){
    this(project,extension,R.def.TASK_GROW_DESCRIPTION);
  }

  public GrowTask(Project project,ShellSpiderExtension extension,String description){
    super(project,extension,description);
  }

  private Map<String,Class<?>> getClassTags(){
      Map<String,Class<?>>tags=new HashMap<>();
      tags.put(R.def.DIMENSION_YAML_TAG,Dimension.class);
      tags.put(R.def.RULE_YAML_TAG,Rule.class);
      return tags;
  }
  
  
  private String genCrawlFunction(Space space){
       Log.q("genCrawlFunction()","site:"+space.getSite());
       Log.q("genCrawlFunction()","type:"+space.getType());
       return null;    
  }

  private void parseSpace(){
     for(Spider spider:extension.getSpiders()){
         for(Space space:spider.getPredationArea().values()){
          String config=project.file(space.getConfig()).getPath();
          try{
             Map data=(Map) YamlTool.read(config,getClassTags());
             if(data!=null){
               String site=(String)data.get(R.def.SPACE_SITE);
               String type=(String)data.get(R.def.SPACE_TYPE);
               List structure=(List)data.get(R.def.SPACE_STRUCTURE);
               List saveTags=(List)data.get(R.def.SPACE_SAVETAGS);

               if(!TaskTool.isNull(site)){
                 space.setSite(site);
                 if(!TaskTool.isNull(type)){
                    if(type.equals(Space.TYPE_SINGLE)||type.equals(Space.TYPE_RANGE)){
                      space.setType(type);
                      space.setStructure(structure);
                      space.setSaveTags(saveTags);

           String content=genCrawlFunction(space);
                      continue;
                    }
                  }
               }
             }
//             throw GrowException.faildParseSpace(space.getName());
         Log.q("parseSpace()","Faild parse space:"+space.getName());
          }catch(FileNotFoundException e){
             Log.q("test()",e.toString());
          }catch(YamlException e){
             Log.q("test()",e.toString());                            }
 Log.q("test()","name:"+space.getName()+ " config:" +config);
       }
     }
  }
  
  @TaskAction
  public void grow(){
      parseSpace();
  }
}
