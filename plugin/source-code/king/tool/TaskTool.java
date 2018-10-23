package king.tool;

import org.gradle.api.Project;

import java.io.File;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import king.tool.Log;

public class TaskTool{

   private TaskTool(){ 
   
   }

   public static boolean copy(Project project,String src,String dst){
        if(project!=null&&src!=null&&dst!=null){
           return project.copy(it -> {
               it.from(src);
               it.into(project.file(dst).getParent());
               it.rename(project.file(src).getName(),project.file(dst).getName());
           }).getDidWork();
        }
        return false;
   }

   public static String E(int n,int s){
      int len=n;
      int step=1;
      String chr=" ";
      switch(s){
         case 2:step=2;chr="  ";break;
         case 5:step=5;chr="     ";break;
         case 10:step=10;chr="          ";break;
         case 20:step=20;chr="                    ";break;
      }
      String all="";
      for(int i=0;i<len;i+=step)all+=chr;
      return all;
   }

   public static String N(int n,int s){
      int len=n;
      int step=1;
      String chr="\n";
      switch(s){
         case 2:step=2;chr="\n\n";break;
         case 5:step=5;chr="\n\n\n\n\n";break;
         case 10:step=10;chr="\n\n\n\n\n\n\n\n\n\n";break;
         case 20:step=20;chr="\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";break;
      }
      String all="";
      for(int i=0;i<len;i+=step)all+=chr;
      return all;
   }
   
   public static String checkValue(String tag,String value){
        if(!isNull(tag)&&value!=null){
            Log.d("checkValue()","tag:"+tag+" value:"+value);
            return tag+value;
        }else{
            Log.d("checkValue()","tag:"+tag+" is null.");
            return "";
        }
   }
   public static String getResourceString(Project project,String file){
     try{
        ClassLoader cl=Thread.currentThread().getContextClassLoader();
        URI uri=cl.getResource(file).toURI();
        return getString(project,uri);
     }catch(URISyntaxException e){
        Log.e("TaskTool.getResourceString()",e.toString());
        return null;
    }
  }

   public static String getString(Project project,URI uri){
      return project.getResources().getText().fromUri(uri).asString();
  }

   public static Writer getWriter(File file){
     try{
      // return new FileWriter(file, true);
       return new BufferedWriter(new FileWriter(file, true));
     }catch(IOException e){
         Log.e("TaskTool.getWriter()",e.toString());
     }
     return null;
   }

   public static boolean write(Writer writer,String content,boolean isAppend,boolean isClosed){
       if(writer!=null&&!isNull(content)){
         try{
           if(isAppend) writer.append(content);                        else writer.write(content);
           if(isClosed) writer.close();
           Log.d("write()","write ok!");
           return true;
         }catch(IOException e){
           Log.e("TaskTool.write()",e.toString());
         }
       }
       return false;
   }

   public static boolean write(File file,String content,boolean isAppend) {  
      return write(getWriter(file),content,isAppend,true);
   }
  
   public static boolean isFile(Project project,String path){
        File f=project.file(path);
        if(f.exists()&&f.isFile()){
            return true;
        }
        return false;
   }

   public static boolean isValidPath(String path){
      if(!isNull(path)){
        String str=path.trim();
        if(str.contains("*")||
            str.contains("\\")||str.contains("/")){
            return false;
        }
        char[] inch={'-',',','!','\'','\"','&','?',':','^'};
        for(int i=0;i<inch.length;i++){
            if(inch[i]==str.charAt(0))return false;
        }
        return true;
      }
      return false;
   }

   public static boolean maybeCreateDir(Project project,String path){
       if(project!=null&&!isNull(path)){
           File f=project.file(path);
           if(f!=null){
             if(!f.exists()){
               f.mkdirs();
               return true;
             }else{
               if(f.isDirectory())return true;
               else return false;
             }
           }  
       }
       return false;
   }

   public static boolean isNull(String value){
       if(value!=null){
         if(value.length()>0){
            return false;
         }
       }
      return true;
  }

   public static boolean isLengthValid(String value,int left,int right){
       if(!isNull(value)){
         int length=getRealLength(value);
         if(left<=length&&length<=right){
           return true;
         }
       }
      return false;
  }

   public static int getRealLength(String str) {
         int m = 0;
         char arr[] = str.toCharArray();
         for (int i = 0; i < arr.length; i++) {
	  char c = arr[i];
	   if ((c >= 0x0391 && c <= 0xFFE5)) {
	      m = m + 2;
           } else if ((c >= 0x0000 && c <= 0x00FF)){
	      m = m + 1;
           }
         }
         return m;
    }
}
