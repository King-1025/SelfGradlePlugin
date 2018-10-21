package king.model;

import com.google.common.base.Objects;

import java.util.List;

public class Dimension{
  private String name;
  private String rule;
  private List save;

  public Dimension(){

  }

  public String getName(){
     return name;
  }

  public void setName(String name){
     this.name=name;
  }
  
  public String getRule(){
     return rule;
  }

  public void setRule(String rule){
     this.rule=rule;
  }

  public List getSave(){
     return save;
  }

  public void setSave(List save){
     this.save=save;
  }

  public int hashCode(){
      return Objects.hashCode(name,rule,save);
  }
}
