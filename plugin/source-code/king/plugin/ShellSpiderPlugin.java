package king.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;

import king.extension.ShellSpiderExtension;
import king.task.EnvironmentCheckTask; 
import king.task.BornTask;
import king.task.GrowTask;
import king.task.AdultTask;
import king.task.CleanTask;

public class ShellSpiderPlugin implements Plugin<Project>
{ 
  static final String EXTENSION_NAME="shspider";

  public void apply(Project project){ 
    ShellSpiderExtension extension=createExtension(project);
    configureMainTasks(project,extension);
  }

  private void configureMainTasks(Project project,ShellSpiderExtension extension){
    TaskContainer taskContainer=project.getTasks();
    EnvironmentCheckTask ektask=taskContainer.create("environmentCheck",EnvironmentCheckTask.class,project,extension);
    BornTask bntask=taskContainer.create("born",BornTask.class,project,extension);
    GrowTask gwtask=taskContainer.create("grow",GrowTask.class,project);
    AdultTask attask=taskContainer.create("adult",AdultTask.class,project);                
    CleanTask cntask=taskContainer.create("clean",CleanTask.class,project,extension);
    attask.dependsOn(gwtask);
    gwtask.dependsOn(bntask);
    bntask.dependsOn(ektask);
  }

  private ShellSpiderExtension createExtension(Project project){
     return project.getExtensions().create(EXTENSION_NAME,ShellSpiderExtension.class,project);
  }

}

