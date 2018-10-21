package king.model;

import com.google.common.base.Objects;
import org.gradle.api.Named;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import groovy.lang.Closure;

public class Space implements Named,Serializable{
  private final String name;
  private String config;
  private String site;
  private String type;
  private List structure;
  private int number;

  public static final String TYPE_SINGLE="SINGLE";
  public static final String TYPE_RANGE="RANGE";

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
 
  public List getStructure(){
     return structure;
  }

  public void setStructure(List structure){
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

  public String getSite(){
     return site;
  }
  
  public void setSite(String site){
     this.site=site;
  }

  public String getType(){
     return type;
  }

  public void setType(String type){
     this.type=type;
  }

  public boolean equals(Object object){
      if(object instanceof Space){
         Space other=(Space)object;
         return Objects.equal(name,other.name)
             && Objects.equal(config,other.config);
      }
      return false;
  }

  public int hashCode(){ 
      return Objects.hashCode(name,config);
  }
     
}
