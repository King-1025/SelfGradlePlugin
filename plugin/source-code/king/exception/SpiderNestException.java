package king.exception;

import king.exception.BasedException;

public class SpiderNestException extends BasedException{

   private SpiderNestException(String message){
         super(message);
   }
   
   public static SpiderNestException invalidNestName(){
        return new SpiderNestException("Spider nest's name should be not empty and it's size in [1,255].");
   }

}
