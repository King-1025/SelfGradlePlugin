package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;

public class AdultTask extends SpiderTask{
  private final static String DEFAULT_DESCRIPTION="成年";
  
  public AdultTask(Project project){
     this(project,DEFAULT_DESCRIPTION);
  }

  public AdultTask(Project project,String description){
     super(project,description);
  }
}
