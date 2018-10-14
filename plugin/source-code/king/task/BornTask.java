package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import king.extension.ShellSpiderExtension;
import king.model.Spider;
import king.exception.BornException;
import king.tool.TaskTool;

public class BornTask extends SpiderTask{
  private final static String DEFAULT_DESCRIPTION="孵化蜘蛛";
  static final String tempDir=".tmp";

  @Inject
  public BornTask(Project project,ShellSpiderExtension extension){
      this(project,extension,DEFAULT_DESCRIPTION);
  }

  public BornTask(Project project,ShellSpiderExtension extension,String description){
      super(project,extension,description);
  }
 
  private boolean write(File file,Spider spider)throws URISyntaxException{ 
    String content=TaskTool.getResourceString(project,"head"); 
    content+="#Author:"+spider.getDescription().getAuthor()+"\n";
    content+="#Email:"+spider.getDescription().getEmail()+"\n";
    content+="#Intent:"+spider.getDescription().getIntent()+"\n";
    content+="#Site:"+spider.getDescription().getWeburl()+"\n";
    return TaskTool.write(file,content,false);
  }

  @TaskAction
  public void born() throws IOException,URISyntaxException{
      String path=extension.getNest().getLocation()+File.separator+tempDir;
      if(TaskTool.maybeCreateDir(project,path)){
         for(Spider spider:extension.getSpiders()){
            File tmp=project.file(path+File.separator+"_"+spider.getName().trim().toLowerCase()+"_born");
            if(tmp.exists()){
              //if(!tmp.delete())throw BornException.faildDeleteTempFile(path);
               continue;
            }
            if(tmp.createNewFile()){
              if(!write(tmp,spider))throw BornException.faildWriteTempFile(path);
            }else{
              throw BornException.faildCreateTempFile(path);
            }
          }        
      }else{
         throw BornException.faildCreateTempDir(path);
      }
  }
}
