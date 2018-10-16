package king.task;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;

import king.extension.ShellSpiderExtension;
import king.model.R;

public class SpiderTask extends DefaultTask{
  protected Project project;
  protected ShellSpiderExtension extension;  

  public SpiderTask(Project project,String description){
      this(project,null,description);
  }

  public SpiderTask(Project project,ShellSpiderExtension extension,String description){
      super();
      this.project=project;
      this.extension=extension;
      this.setGroup(R.def.GROUP_SHELL_SPIDER);
      this.setDescription(description);
  }

  public void setGroup(String group){
      super.setGroup(group);
  }

  public void setDescription(String description){
      super.setDescription(description);
  }
}
