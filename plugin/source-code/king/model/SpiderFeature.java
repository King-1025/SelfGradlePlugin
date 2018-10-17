package king.model;

public class SpiderFeature{
   
   private boolean enableProcess=true;
   private boolean enableRange=true;
   private boolean enableCache=false;
   private boolean enableLogLevel=true;
   private boolean enableLogStyle=false;  
   private boolean enableLogFile=true;

   public SpiderFeature(){

   }
   
   public boolean getEnableLogFile(){
        return enableLogFile;
   }

   public void setEnableLogFile(boolean enableLogFile){
        this.enableLogFile=enableLogFile;
   }

   public boolean getEnableLogLevel(){
        return enableLogLevel;
   }

   public void setEnableLogLevel(boolean enableLogLevel){
        this.enableLogLevel=enableLogLevel;
   }

   public boolean getEnableLogStyle(){
        return enableLogStyle;
   }

   public void setEnableLogStyle(boolean enableLogStyle){
        this.enableLogStyle=enableLogStyle;
   }


   public boolean getEnableProcess(){
        return enableProcess;
   }

   public void setEnableProcess(boolean enableProcess){
        this.enableProcess=enableProcess;
   }

   public boolean getEnableCache(){
        return enableCache;
   }

   public void setEnableCache(boolean enableCache){
        this.enableCache=enableCache;
   }

   public boolean getEnableRange(){
        return enableRange;
   }

   public void setEnableRange(boolean enableRange){
        this.enableRange=enableRange;
   }
}
