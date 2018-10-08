package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;

public class BornTask extends SpiderTask{
  private final static String DEFAULT_DESCRIPTION="孵化蜘蛛";
  
  public BornTask(Project project){
      this(project,DEFAULT_DESCRIPTION);
  }

  public BornTask(Project project,String description){
      super(project,description);
  }
}
