package king.task;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;

public class SpiderTask extends DefaultTask{
  public final static String GROUP_SHELL_SPIDER="Shell Spider";
  protected Project project;
  
  public SpiderTask(Project project,String description){
      super();
      this.project=project;
      this.setGroup(GROUP_SHELL_SPIDER);
      this.setDescription(description);
  }

  public void setGroup(String group){
      super.setGroup(group);
  }

  public void setDescription(String description){
      super.setDescription(description);
  }
}
