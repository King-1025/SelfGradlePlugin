package king.exception;

import org.gradle.api.GradleException;

public abstract class BasedException extends GradleException{
   public BasedException(String message){
          super(message);
   }
}
