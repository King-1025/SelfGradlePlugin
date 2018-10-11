package king.model;

import king.model.SpiderDescriptor;
import king.model.SpiderFeature;
import king.model.Space;

import java.util.Set;

public class Spider {
  private String id;
  private SpiderDescriptor description;
  private SpiderFeature feature;
  private Set<Space> predationSpace;
 
  public Spider(){

  }
 
  public String getId(){
      return id;
  }
  
  public void setId(String id){
      this.id=id;
  }

  public SpiderDescriptor getDescription(){
      return description;
  }
  
  public void setDescription(SpiderDescriptor description){
      this.description=description;
  }

  public SpiderFeature getFeature(){
      return feature;
  }

  public void setFeature(SpiderFeature feature){
      this.feature=feature;
  }

  public Set<Space> getPredationSpace(){
      return predationSpace;
  }

  public void setPredationSpace(Set<Space> predationSpace){
      this.predationSpace=predationSpace;
  }
}
