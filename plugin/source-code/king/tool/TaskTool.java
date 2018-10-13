package king.tool;

import org.gradle.api.Project;

public class TaskTool{

   private TaskTool(){ 
   
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
