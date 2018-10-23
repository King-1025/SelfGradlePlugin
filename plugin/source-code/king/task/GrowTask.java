package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;
import java.io.File;
import java.io.Writer;
import java.util.List;

import king.model.R;
import king.tool.YamlTool;
import king.tool.TaskTool;
import king.extension.ShellSpiderExtension;
import king.model.Space;
import king.model.Spider;
import king.exception.GrowException;
import king.model.Parser;

public class GrowTask extends SpiderTask{

  private Parser parser;
  
  @Inject
  public GrowTask(Project project,ShellSpiderExtension extension){
    this(project,extension,R.def.TASK_GROW_DESCRIPTION);
  }

  public GrowTask(Project project,ShellSpiderExtension extension,String description){
    super(project,extension,description);
  }
  
  public void setParser(Parser parser){
      this.parser=parser;
  }

  public Parser getParser(){
      return parser;
  }

  private File getTempFile(Spider spider){
       File tmp=project.file(spider.getTempDir()+File.separator+R.def.GROW_FILE_PREFIX+spider.getName().trim().toLowerCase()+R.def.GROW_FILE_SUBFIX);
       if(project.file(spider.getTempFilePath()).renameTo(tmp)){
          spider.setTempFilePath(tmp.getPath());
          return tmp;
      }else{
          return null;
      }
  }

  private boolean write(Writer writer,Space space){
     if(parser!=null){
        String content=TaskTool.N(1,2)+parser.genCrawlFunction(space);
        return TaskTool.write(writer,content,true,false);
     }
     return false;
  }
  
  @TaskAction
  public void grow(){
     for(Spider spider:extension.getSpiders()){
      if(spider.getTempFilePath()!=null){        
         File tmp=getTempFile(spider);
         if(tmp==null){
            throw GrowException.faildCreateTempFile(spider.getName());
         }
         Writer writer=TaskTool.getWriter(tmp); 
         for(Space space:spider.getPredationArea().values()){
           if(YamlTool.configure(space)){
             if(!write(writer,space)) throw GrowException.faildWriteTempFile(spider.getName());
           }else{
             throw GrowException.faildConfigureSpace(space.getName());
           }
         }
         String content=TaskTool.N(1,2)+"function crawl()\n{";
         if(parser!=null){
            List<String> listFun=parser.listFunctionName();
            if(listFun!=null){
               for(String fun:listFun){
                  content+="\n  "+fun;
               }
               for(String fun:listFun){
                  content+="\n  log i \""+fun+" TOTAL:${"+fun+"_CRAWL_TOTAL}\"";
               }
             }
         }
         content+="\n  log i \"all crawl tasks finished!\"";
         content+="\n}";
         TaskTool.write(writer,content,true,true);  
      }
    }
  }
}
