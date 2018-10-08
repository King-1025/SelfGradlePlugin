package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;

import javax.inject.Inject;

public class GrowTask extends SpiderTask{
  private final static String DEFAULT_DESCRIPTION="发育蜘蛛";
  
  @Inject
  public GrowTask(Project project){
    this(project,DEFAULT_DESCRIPTION);
  }

  public GrowTask(Project project,String description){
    super(project,description);
  }

}
