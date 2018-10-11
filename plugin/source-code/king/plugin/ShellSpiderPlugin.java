package king.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;

import king.extension.ShellSpiderExtension;
import king.task.EnvironmentCheckTask; 
import king.task.BornTask;
import king.task.GrowTask;
import king.task.AdultTask;

public class ShellSpiderPlugin implements Plugin<Project>
{
  public void apply(final Project project){
    ShellSpiderExtension sse=project.getExtensions().create("shspider",ShellSpiderExtension.class,project);

    TaskContainer taskContainer=project.getTasks();
    EnvironmentCheckTask ektask=taskContainer.create("environmentCheck",EnvironmentCheckTask.class,project);
    BornTask bntask=taskContainer.create("born",BornTask.class,project);
    GrowTask gwtask=taskContainer.create("grow",GrowTask.class,project);
    AdultTask attask=taskContainer.create("adult",AdultTask.class,project);                
    attask.dependsOn(gwtask);
    gwtask.dependsOn(bntask);
    bntask.dependsOn(ektask);
  }
}

