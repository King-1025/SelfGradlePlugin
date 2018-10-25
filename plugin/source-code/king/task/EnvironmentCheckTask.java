package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.Input;

import javax.inject.Inject;
import java.io.File;
import java.util.Map;
import java.util.HashMap;

import king.tool.Log;
import king.tool.TaskTool;
import king.extension.ShellSpiderExtension;
import king.exception.SpiderNestException;
import king.model.Space;
import king.exception.SpaceException;
import king.exception.SpiderException;
import king.model.Spider;
import king.model.R;

public class EnvironmentCheckTask extends SpiderTask{

  private Map<String,Space> spaceMap;

  @Inject 
  public EnvironmentCheckTask(Project project,ShellSpiderExtension extension){
      this(project,extension,R.def.TASK_ENVIRONMENT_CHECK_DESCRIPTION);
  }
  
  public EnvironmentCheckTask(Project project,ShellSpiderExtension extension,String description){
      super(project,extension,description);
  }
  
  private void checkSpiders(){
      for(Spider spider:extension.getSpiders()){
         String[] master=spider.getMaster();
         if(master!=null){
           if(spaceMap!=null){
             Map<String,Space> tmmp=new HashMap<>();
             for(String name:master){
                if(!spaceMap.containsKey(name)){
                  throw SpiderException.notFoundSpace(name);
                }else{
                  tmmp.put(name,spaceMap.get(name));
                }
             }
             spider.setPredationArea(tmmp);
           }else{
              throw SpiderException.invalidWeb();
           }
         }else{
           throw SpiderException.withoutMaster(spider.getName());
         }
     }
  }

  private void checkWeb(){
      for(Space space : extension.getWeb()){
          String config=space.getConfig();
          if(TaskTool.isValidPath(config)){
             config=config.trim().replace(R.def.CONFIG_PATH_SEPARATOR,File.separator);
             config=extension.getNest().getGrowthArea()+File.separator+config;
             if(TaskTool.isFile(project,config)){
               //在某些情况下，config需要全路径，否则，会导致Yaml解析时，找不到配置文件
               space.setConfig(project.file(config).getPath());
             }else{
                throw SpaceException.invalidConfig(config);
             }
          }else{
            throw SpaceException.invalidPath(config);
          }
          if(spaceMap==null){
             spaceMap=new HashMap<String,Space>();
          }
          spaceMap.put(space.getName(),space);
      }
  }

  private void checkSpiderNest(){
    String name=extension.getNest().getName();
    String location=extension.getNest().getLocation();
    if(name!=null){
       if(TaskTool.isLengthValid(name,R.def.MIN_NAME_LENGTH,R.def.MAX_NAME_LENGTH)){
         location=location+File.separator+name;     
       }else{
         throw SpiderNestException.invalidNestName();
       }
    }
    if(!TaskTool.maybeCreateDir(project,location)){
       throw SpiderNestException.invalidLocation(location);
    }
    String area=extension.getNest().getGrowthArea();
    if(!TaskTool.maybeCreateDir(project,area)){
       throw SpiderNestException.invalidGrowthArea(area);
    }
  }
   
  @TaskAction
  public void check(){
     checkSpiderNest();
     checkWeb();
     checkSpiders();
  } 
}
