package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;

import javax.inject.Inject;

import king.model.R;

public class AdultTask extends SpiderTask{
  
  @Inject
  public AdultTask(Project project){
     this(project,R.def.TASK_ADULT_DESCRIPTION);
  }

  public AdultTask(Project project,String description){
     super(project,description);
  }
}
