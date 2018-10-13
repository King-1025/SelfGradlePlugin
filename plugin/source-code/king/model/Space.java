package king.model;

//import com.google.common.base.Objects;
import org.gradle.api.Named;

import king.model.Dimension;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import groovy.lang.Closure;

public class Space implements Named,Serializable{
  private String name;
  private String config;
  private List<Dimension> structure;
  private int number;
  private String site;

  public Space(String name){
     this.name=name;
     setStructure(new ArrayList<>());
  }
  
  public String getName(){
     return name;
  }

  public String getConfig(){
     return config;
  }
  
  public void setConfig(String config){
     this.config=config;
  }
  
  @Nullable
  public List<Dimension> getStructure(){
     return structure;
  }

  public void setStructure(List<Dimension> structure){
     this.structure=structure;
     updateNumber();
  }

  public int getNumber(){
     return number;
  }

  private void updateNumber(){
    if(structure!=null){
       number=structure.size();
    }else{
       number=0;
    }
  }

  @Nullable 
  public String getSite(){
     return site;
  }
  
  public void setSite(String site){
     this.site=site;
  }

  public boolean equals(Object object){
      if(object instanceof Space){
         Space other=(Space)object;
         return true;
  //       return Objects.equal(name,other.name)
    //         && Objects.equal(config,other.config);
      }
      return false;
  }

  public int hashCode(){
      return 0;   
   //   return Objects.hashCode(name,config);
  }
     
}
