package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.Input;

import javax.inject.Inject;

import king.tool.Log;
import king.tool.TaskTool;
import king.extension.ShellSpiderExtension;
import king.exception.SpiderNestException;

public class EnvironmentCheckTask extends SpiderTask{
  private final static String DEFAULT_DESCRIPTION="环境检查";
  private ShellSpiderExtension extension;

  @Inject 
  public EnvironmentCheckTask(Project project,ShellSpiderExtension extension){
      this(project,extension,DEFAULT_DESCRIPTION);
  }
  
  public EnvironmentCheckTask(Project project,ShellSpiderExtension extension,String description){
      super(project,description);
      this.extension=extension;
  }
  
  @TaskAction
  public void check(){
     if(!TaskTool.isLengthValid(extension.getNest().getName(),1,255)){
       throw SpiderNestException.invalidNestName();
     }
  } 
}
