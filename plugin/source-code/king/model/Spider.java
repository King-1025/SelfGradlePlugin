package king.model;

//import com.google.common.base.Objects;

import org.gradle.api.Named;
import org.gradle.api.Incubating;

import king.model.SpiderDescriptor;
import king.model.SpiderFeature;
import king.model.ExtensionModel;

import javax.annotation.Nullable;
import java.io.Serializable;

import groovy.lang.Closure;

public class Spider extends ExtensionModel implements Named,Serializable {
  private String id;
  private final String name;
  private SpiderDescriptor description=new SpiderDescriptor();
  private SpiderFeature feature=new SpiderFeature();

  private String[] master;
 
  public Spider(String name){
     this.name=name;
  }
 
  public String getName(){
     return name;
  }

  public String getId(){
      return id;
  }
  
  public void setId(String id){
      this.id=id;
  }
  
  @Nullable
  public SpiderDescriptor getDescription(){
      return description;
  }

  public void description(Closure closure){
      configure(description,closure);
  }

  @Nullable
  public SpiderFeature getFeature(){
      return feature;
  }
  
  public void feature(Closure closure){
      configure(feature,closure);
  }
  
  @Nullable
  public String[] getMaster(){
       return master;
  }
 
  public void setMaster(String[] master){
       this.master=master;
  }

  public boolean equals(Object object){
      if(object instanceof Spider){
         Spider other=(Spider)object;
         return true;
        // return Objects.equal(name,other.name)
        //     && Objects.equal(id,other.id);
      }
      return false;
  }
 
  public int hashCode(){
      return 0;
     // return Objects.hashCode(name,id);
  }
}
