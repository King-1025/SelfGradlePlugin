package king.task;

import org.gradle.api.Task;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import javax.inject.Inject;
import java.io.File;
import java.io.Writer;
import java.io.IOException;

import king.extension.ShellSpiderExtension;
import king.model.Spider;
import king.exception.BornException;
import king.tool.TaskTool;
import king.model.SpiderDescriptor;
import king.tool.Log;
import king.model.SpiderFeature;
import king.model.R;

public class BornTask extends SpiderTask{

  private String tempDir=R.def.TASK_BORN_TEMP_DIR;
  private boolean writerStatus;

  @Inject
  public BornTask(Project project,ShellSpiderExtension extension){
      this(project,extension,R.def.TASK_BORN_DESCRIPTION);
  }

  public BornTask(Project project,ShellSpiderExtension extension,String description){
      super(project,extension,description);
  }
  
  private boolean writeHead(Writer writer,SpiderDescriptor descriptor){
   Log.q("writeHead()","I am called.");
   if(descriptor!=null&&writerStatus){
     String content=R.tag.SCRIPT_HEAD+
     TaskTool.checkValue("\n"+R.tag.INTENT,descriptor.getIntent())+
     TaskTool.checkValue("\n"+R.tag.AUTHOR,descriptor.getAuthor())+
     TaskTool.checkValue("\n"+R.tag.EMAIL,descriptor.getEmail())+
     TaskTool.checkValue("\n"+R.tag.VERSION,descriptor.getVersion())+
     TaskTool.checkValue("\n"+R.tag.DATE,descriptor.getDate())+
     TaskTool.checkValue("\n"+R.tag.SITE,descriptor.getWeburl());
     return TaskTool.write(writer,content+"\n",false,!writerStatus);
   }else{
     Log.q("deacript is null","");
     return false;
   }
 }

  private boolean writeParma(Writer writer,Spider spider){
       if(writerStatus){
         Log.q("writeParma()","I am called.");
         String content=TaskTool.N(1,2)+
         R.command.SET_ROOT+"\n"+
         R.command.SET_REQUIREMENT+"\n"+
         R.command.SET_CURL_OPTION+"\n"+
         R.command.SET_SAVE_TYPE+"\n"+
         R.command.SET_SAVE_FILE+"\n"+
         R.command.SET_SELF_UA+"\n";
         SpiderFeature feature=spider.getFeature();
         if(feature!=null){
           if(feature.getEnableProcess()){
              content+=R.command.SET_PROCESS+"\n";
           }
           if(feature.getEnableCache()){
              content+=R.command.SET_CACHE+"\n";
           }
           if(feature.getEnableRange()){
              content+=R.command.SET_RANGE+"\n";
           }
           if(feature.getEnableLogFile()){
              content+=R.command.SET_LOG_FILE+"\n";
           }
           if(feature.getEnableLogLevel()){
              content+=R.command.SET_LOG_LEVEL+"\n";
           }
           if(feature.getEnableLogStyle()){
              content+=R.command.SET_LOG_STYLE+"\n";
           }
          }
         SpiderDescriptor description=spider.getDescription();
         if(description!=null){
            String str=description.getVersion();
            if(str!=null){
               content+=R.var.VERSION+"=\""+str+"\"\n";     
             }
            str=description.getIntent();
            if(str!=null){
               content+=R.var.INTENT+"=\""+str+"\"\n"; 
            }
         }
         return TaskTool.write(writer,content,true,!writerStatus);
       }else{
         return false;
       }
  }

  private boolean writeFunc(Writer writer){
      if(writerStatus){
         Log.q("writeFunc()","I am called.");
         String content=TaskTool.N(1,2)+TaskTool.getResourceString(project,R.file.FUNCTION);
         return TaskTool.write(writer,content,true,!writerStatus);
      }else{
         return false;
      }
  }
  
  private boolean writeOther(Writer writer){
       if(writerStatus){
         Log.q("writeOther()","I am called.");
         String content=" ";
         content=R.command.APP_START;
         writerStatus=false;
         return TaskTool.write(writer,content,true,!writerStatus);
       }else{
         return false;
       }
  }

  private boolean write(File file,Spider spider){
       Log.q("write()","spider:"+spider.getName());
       Writer writer=TaskTool.getWriter(file);
       writerStatus=true;
       return writeHead(writer,spider.getDescription())
              && writeParma(writer,spider)
              && writeFunc(writer)
              && writeOther(writer);
  }

  @TaskAction
  public void born() throws IOException {
      String path=extension.getNest().getLocation()+File.separator+tempDir;
      if(TaskTool.maybeCreateDir(project,path)){
         for(Spider spider:extension.getSpiders()){
            File tmp=project.file(path+File.separator+R.def.BORN_FILE_PREFIX+spider.getName().trim().toLowerCase()+R.def.BORN_FILE_SUBFIX);
            if(tmp.exists()){
              //if(!tmp.delete())throw BornException.faildDeleteTempFile(path);
              // continue;
              tmp.delete();
              Log.q("born()","tmp delete ok!");
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
