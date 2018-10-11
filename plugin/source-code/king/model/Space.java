package king.model;

import king.model.Dimension;
import java.util.List;

public class Space{
  private String name;
  private String config;
  private List<Dimension> structure;

  public Space(){
  
  }
  
  public String getName(){
     return name;
  }
 
  public void setName(String name){
     this.name=name;
  }
  
  public String getConfig(){
     return config;
  }
  
  public void setConfig(String config){
     this.config=config;
  }

  public List<Dimension> getStructure(){
     return structure;
  }

  public void setStructure(List<Dimension> structure){
     this.structure=structure;
  }
  
}
