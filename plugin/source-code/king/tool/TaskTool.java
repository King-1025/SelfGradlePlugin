package king.tool;

import org.gradle.api.Project;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import king.tool.Log;

public class TaskTool{

   private TaskTool(){ 
   
   }

   public static String getResourceString(Project project,String file) throws URISyntaxException{
      ClassLoader cl=Thread.currentThread().getContextClassLoader();
      URI uri=cl.getResource(file).toURI();
      return getString(project,uri);
   }

   public static String getString(Project project,URI uri){
      return project.getResources().getText().fromUri(uri).asString();
  }

   public static boolean write(File file,String content,boolean isAppend){
    try{
       FileWriter fw = new FileWriter(file, true);
       BufferedWriter bw = new BufferedWriter(fw);
       if(isAppend) bw.append(content);
       else bw.write(content);
       bw.close();
       fw.close();
       return true;
   }catch(IOException e){
       Log.e("TaskTool.write()",e.toString());
       return false;
   }
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
