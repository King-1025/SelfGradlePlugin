package king.exception;

import king.exception.BasedException;

public class BornException extends BasedException{

  private BornException(String message){
        super(message);
  }

  public static BornException faildCreateTempDir(String path){
        return new BornException("Faild to create temp dir:"+path);
  }

 public static BornException faildCreateTempFile(String path){                 
        return new BornException("Faild to create temp file:"+path);
  }

 public static BornException faildDeleteTempFile(String path){
        return new BornException("Faild to delete temp file:"+path);
 }

 public static BornException faildWriteTempFile(String path){  
        return new BornException("Faild to write temp file:"+path);
 }

}
