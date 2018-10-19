package king.model;

import java.util.List;

import king.model.Rule;

public class Dimension{
  private String name;
  private List<Rule>rules;
  private String follow;

  public Dimension(){

  }

  public String getName(){
     return name;
  }

  public void setName(String name){
     this.name=name;
  }
  
  public String getFollow(){
     return follow;
  }

  public void setFollow(String follow){
     this.follow=follow;
  }

  public List<Rule> getRules(){
     return rules;
  }

  public void setRules(List<Rule> rules){
     this.rules=rules;
  }
}
