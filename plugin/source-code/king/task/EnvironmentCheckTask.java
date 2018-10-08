package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;

public class EnvironmentCheckTask extends SpiderTask{
  private final static String DEFAULT_DESCRIPTION="环境检查";

  @Inject 
  public EnvironmentCheckTask(Project project){
      this(project,DEFAULT_DESCRIPTION);
  }
  
  public EnvironmentCheckTask(Project project,String description){
      super(project,description);
  }
  
  @TaskAction
  public void check(){
     System.out.println("everything is ok!");
  } 
}
