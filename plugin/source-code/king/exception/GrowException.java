package king.exception;

import king.exception.BasedException;

public class GrowException extends BasedException{

  private GrowException(String message){
        super(message);
  }
  
  public static GrowException faildParseSpace(String space){
        return new GrowException("Faild to parse space:"+space); 
  }

  public static GrowException faildCreateTempDir(String path){
        return new GrowException("Faild to create temp dir:"+path);
  }

 public static GrowException faildCreateTempFile(String path){                 
        return new GrowException("Faild to create temp file:"+path);
  }

 public static GrowException faildDeleteTempFile(String path){
        return new GrowException("Faild to delete temp file:"+path);
 }

 public static GrowException faildWriteTempFile(String path){  
        return new GrowException("Faild to write temp file:"+path);
 }

}
