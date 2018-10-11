package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.Input;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;
import org.gradle.api.logging.LogLevel;

import javax.inject.Inject;

public class EnvironmentCheckTask extends SpiderTask{
  private final static String DEFAULT_DESCRIPTION="环境检查";
  private String message;
  private final static Logger logger = Logging.getLogger(EnvironmentCheckTask.class);
  
  @Inject 
  public EnvironmentCheckTask(Project project){
      this(project,DEFAULT_DESCRIPTION);
  }
  
  public EnvironmentCheckTask(Project project,String description){
      super(project,description);
  }
  
  @Input
  public String getMessage(){
      return message;
  }

  public void setMessage(String message){
      this.message=message;
  }
  
  @TaskAction
  public void check(){
    if(message!=null){ 
       logger.log(LogLevel.QUIET,message);
     }
  } 
}
