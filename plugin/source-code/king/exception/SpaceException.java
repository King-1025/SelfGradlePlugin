package king.exception;

import king.exception.BasedException;

public class SpaceException extends BasedException{

  private SpaceException(String message){
        super(message);
  }

  public static SpaceException invalidPath(String path){
        return new SpaceException("Invalid path:"+path);
  }

  public static SpaceException invalidConfig(String config){
        return new SpaceException("Invalid config:"+config);     }

}
