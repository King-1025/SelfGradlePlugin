package king.exception;

import king.exception.BasedException;

public class AdultException extends BasedException{

  private AdultException(String message){
        super(message);
  }
  
  public static AdultException faildMakeSpider(String spider){
        return new AdultException("Faild to make spider:"+spider); 
  }

 public static AdultException faildCopyTempFile(String path){                 
        return new AdultException("Faild to copy temp file:"+path);
  }

}
