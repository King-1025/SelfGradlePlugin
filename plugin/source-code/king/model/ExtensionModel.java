package king.model;

import groovy.lang.Closure;

public abstract class ExtensionModel{

   public Object configure(Object object,Closure closure){
      if(object!=null&&closure!=null){
          closure.setResolveStrategy(Closure.DELEGATE_ONLY);
          closure.setDelegate(object);
          closure.call();
      }
      return object;
  }

}
