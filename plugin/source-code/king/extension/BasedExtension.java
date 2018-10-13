package king.extension;

import org.gradle.api.Project;

import king.tool.ExtensionTool;

public abstract class BasedExtension {
   protected Project project;

   public <T> T block(String name,Class<T> type,Object... args){
      return ExtensionTool.maybeCreate(this,name,type,args); 
  }
  
  public Project getProject(){
      return project;
  }

  public void setProject(Project project){
      this.project=project;
  }
}
