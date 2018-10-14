package king.exception;

import king.exception.BasedException;

public class SpiderNestException extends BasedException{

   private SpiderNestException(String message){
         super(message);
   }
   
   public static SpiderNestException invalidNestName(){
        return new SpiderNestException("Spider nest's name should be not empty and it's size in [1,255].");
   }
   
  public static SpiderNestException invalidLocation(String location){
        return new SpiderNestException("Your spider nest is at a invalid location("+location+").");
  }

  public static SpiderNestException invalidGrowthArea(String area){
        return new SpiderNestException("Sorry,spiders cann't grow at area("+area+").Please change it.");                         }

}
