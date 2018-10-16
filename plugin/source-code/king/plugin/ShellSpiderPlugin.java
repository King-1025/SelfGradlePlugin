package king.plugin;

//import org.gradle.api.initialization.dsl.ScriptHandler;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;

import king.extension.ShellSpiderExtension;
import king.task.EnvironmentCheckTask; 
import king.task.BornTask;
import king.task.GrowTask;
import king.task.AdultTask;
import king.task.CleanTask;
import king.model.R;

public class ShellSpiderPlugin implements Plugin<Project>
{ 
  public void apply(Project project){ 
  //  configureScriptDependencies(project);
    ShellSpiderExtension extension=createExtension(project);
    configureMainTasks(project,extension);
  }

  private void configureMainTasks(Project project,ShellSpiderExtension extension){
    TaskContainer taskContainer=project.getTasks();
    EnvironmentCheckTask ektask=taskContainer.create(R.def.TASK_ENVIRONMENT_CHECK,EnvironmentCheckTask.class,project,extension);
    BornTask bntask=taskContainer.create(R.def.TASK_BORN,BornTask.class,project,extension);
    GrowTask gwtask=taskContainer.create(R.def.TASK_GROW,GrowTask.class,project,extension);
    AdultTask attask=taskContainer.create(R.def.TASK_ADULT,AdultTask.class,project);                
    CleanTask cntask=taskContainer.create(R.def.TASK_CLEAN,CleanTask.class,project,extension);
    attask.dependsOn(gwtask);
    gwtask.dependsOn(bntask);
    bntask.dependsOn(ektask);
  }

  private ShellSpiderExtension createExtension(Project project){
     return project.getExtensions().create(R.def.EXTENSION_NAME,ShellSpiderExtension.class,project);
  }
  
  private void configureScriptDependencies(Project project){
      //project.getBuildscript()
      project.getDependencies().add("implementation","com.google.guava:guava:26.0-jre");
  }
}

