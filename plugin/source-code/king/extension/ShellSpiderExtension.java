package king.extension;

import org.gradle.api.Project;

import java.io.File;
import javax.inject.Inject;

public class ShellSpiderExtension extends BasedExtension{
   private String spiderName;
   private String spiderDescription;
   private String spiderVersion;
   private File rootDir;
   private String curl;
   private String sed;
   private String awk;
   private String ua;
   private String targetSite;
   private File outputDir;
   private String saveName;
   private boolean enableInternalUA;
   private File actionDir;

   private final static String DEFAULT_OUTPUT_DIR="output";
   private final static String DEFAULT_ACTION_DIR="action";
   
   @Inject
   public ShellSpiderExtension(Project project){
         target=project;
         initSpiderDetails(); 
   }

   private void initSpiderDetails(){
         spiderName=target.getName();
         spiderDescription=target.getDescription();
         spiderVersion=String.valueOf(target.getVersion());
         
         rootDir=target.getRootDir();
         actionDir=new File(rootDir.toString()+rootDir.pathSeparator+"action");
         outputDir=new File(rootDir.toString()+rootDir.pathSeparator+"output");
         saveName="";         
   }
  
   public String getSpiderName(){
      return spiderName;
   }

   public void setSpiderName(String spiderName){
      this.spiderName=spiderName;
   }
}
