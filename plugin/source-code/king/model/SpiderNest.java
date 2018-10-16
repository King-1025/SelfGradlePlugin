package king.model;

import king.model.R;

public class SpiderNest{
  private String name;
  private String level;
  private String location;
  private String growthArea;
 
  public SpiderNest(){
     level=R.def.NEST_LEVEL;
     location=R.def.NEST_LOCATION;
     growthArea=R.def.NEST_GROWTH_AREA;
  }
  
  public String getName(){
      return name;
  }
  
  public void setName(String name){
      this.name=name;
  }

  public String getLevel(){
      return level;
  }

  public void setLevel(String level){
      this.level=level;
  }

  public String getLocation(){
      return location;
  }
  
  public void setLocation(String location){
      this.location=location;
  }

  public String getGrowthArea(){
      return growthArea;
  }

  public void setGrowthArea(String growthArea){
      this.growthArea=growthArea;
  }

}
