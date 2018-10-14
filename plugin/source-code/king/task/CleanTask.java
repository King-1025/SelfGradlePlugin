package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;

import king.extension.ShellSpiderExtension;

public class CleanTask extends SpiderTask{
  private final static String DEFAULT_DESCRIPTION="清理";
  
  @Inject
  public CleanTask(Project project,ShellSpiderExtension extension){
    this(project,extension,DEFAULT_DESCRIPTION);
  }

  public CleanTask(Project project,ShellSpiderExtension extension,String description){
    super(project,extension,description);
  }
  
  @TaskAction
  public void clean(){
    project.delete(extension.getNest().getLocation());
  }
}
