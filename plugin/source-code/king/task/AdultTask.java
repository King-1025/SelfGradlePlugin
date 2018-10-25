package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;
import java.io.File;
import java.io.Writer;

import king.model.R;
import king.extension.ShellSpiderExtension;
import king.model.Spider;
import king.tool.TaskTool;
import king.exception.AdultException;
import king.tool.Log;

public class AdultTask extends SpiderTask{
  
  @Inject
  public AdultTask(Project project,ShellSpiderExtension extension){
     this(project,extension,R.def.TASK_ADULT_DESCRIPTION);
  }

  public AdultTask(Project project,ShellSpiderExtension extension,String description){
     super(project,extension,description);
  }

  private boolean write(File file){
     if(file!=null){
        Writer writer=TaskTool.getWriter(file);
        file.setExecutable(true);
        String content=TaskTool.N(3,1)+R.command.APP_START;
        return TaskTool.write(writer,content,true,true);    
     }
     return false;
  }

  @TaskAction
  public void adult(){
    String path=extension.getNest().getLocation()+File.separator+TaskTool.checkValue(extension.getNest().getName(),"");
    String prefix=TaskTool.checkValue(extension.getNest().getName(),R.def.NAME_LINK_CHAR)+TaskTool.checkValue(extension.getNest().getLevel(),R.def.NAME_LINK_CHAR);
    for(Spider spider:extension.getSpiders()){ 
       String name="";
       if(!TaskTool.isNull(spider.getId())){
          name+=spider.getId();
       }else{
          name+=spider.getName();
       }
       name+=TaskTool.checkValue(R.def.NAME_LINK_CHAR,spider.getDescription().getVersion());
       name+=R.def.SPIDER_FILE_SUBFIX;
       File tmp=project.file(path+File.separator+name);
       Log.q("adult()","path:"+tmp.getPath());
       if(project.file(spider.getTempFilePath()).renameTo(tmp)){
          if(!write(tmp)) throw AdultException.faildMakeSpider(spider.getName());
       }else{
          throw AdultException.faildCopyTempFile(spider.getName());
       }
    }
  }
}
