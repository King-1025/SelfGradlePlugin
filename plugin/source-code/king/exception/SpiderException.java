package king.exception;

import king.exception.BasedException;

public class SpiderException extends BasedException{

  private SpiderException(String message){
        super(message);
  }

  public static SpiderException notFoundSpace(String name){
       return new SpiderException("Not found space:"+name);
  }

  public static SpiderException withoutMaster(String name){
       return new SpiderException("Without master! spider:"+name);     
}
  public static SpiderException invalidWeb(){
      return new SpiderException("There aren't any spaces.");
  }
}
