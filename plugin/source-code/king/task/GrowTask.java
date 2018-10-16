package king.task;

import com.esotericsoftware.yamlbeans.YamlException; 
import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.io.FileNotFoundException;

import king.model.R;
import king.tool.YamlTool;
import king.extension.ShellSpiderExtension;
import king.model.Space;
import king.model.Spider;
import king.tool.Log;
import king.model.Dimension;

public class GrowTask extends SpiderTask{
  
  @Inject
  public GrowTask(Project project,ShellSpiderExtension extension){
    this(project,extension,R.def.TASK_GROW_DESCRIPTION);
  }

  public GrowTask(Project project,ShellSpiderExtension extension,String description){
    super(project,extension,description);
  }
  
  private void test(){
     for(Spider spider:extension.getSpiders()){
         for(Space space:spider.getPredationArea().values()){
          String config=project.file(space.getConfig()).getPath();
          try{
             List data=(List)YamlTool.read(config,space.getName(),R.def.DIMENSION_YAML_TAG,Dimension.class);
             if(data!=null){
               int size=data.size();
               Log.q("space:"+space.getName(),"size:"+size);
               for(int i=0;i<size;i++){
                  Dimension dim=(Dimension)data.get(i);
                  Log.q(i+"","name:"+dim.getName());
               }
             }else{
               Log.q(space.getName(),"list is null.");
             }
          }catch(FileNotFoundException e){
             Log.q("test()",e.toString());
          }catch(YamlException e){
             Log.q("test()",e.toString());                            }
 Log.q("test()","name:"+space.getName()+ " config:" +config);
       }
     }
  }
  
  @TaskAction
  public void grow(){
      test();
  }
}
