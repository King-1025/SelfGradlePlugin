package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;

public class EnvironmentCheckTask extends SpiderTask{
  private final static String DEFAULT_DESCRIPTION="环境检查";

  public EnvironmentCheckTask(Project project){
      this(project,DEFAULT_DESCRIPTION);
  }

  public EnvironmentCheckTask(Project project,String description){
      super(project,description);
  }
 
}
