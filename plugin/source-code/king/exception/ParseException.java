package king.exception;

import king.exception.BasedException;

public class ParseException extends BasedException{

  private ParseException(String message){
        super(message);
  }
  
  public static ParseException notFoundType(String type){
        return new ParseException("Not found type:"+type); 
  }

  public static ParseException notFoundRule(String name){
        return new ParseException("Dimension:"+name+" Not found rule!"); 
  }

  public static ParseException notFoundMode(String mode){
        return new ParseException("Not found mode:"+mode); 
  }

}
