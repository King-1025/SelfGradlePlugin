package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;

import king.extension.ShellSpiderExtension;
import king.model.R;

public class CleanTask extends SpiderTask{
  
  @Inject
  public CleanTask(Project project,ShellSpiderExtension extension){
    this(project,extension,R.def.TASK_CLEAN_DESCRIPTION);
  }

  public CleanTask(Project project,ShellSpiderExtension extension,String description){
    super(project,extension,description);
  }
  
  @TaskAction
  public void clean(){
    project.delete(extension.getNest().getLocation());
  }
}
