package king.model;

public class SpiderNest{
  private String name;
  private String level;
  private String location;
  private String growthArea;

  static final String DEFAULT_LEVEL="0"; 
  static final String DEFAULT_LOCATION="nest";
  static final String DEFAULT_GROWTH_AREA="growth";
 
  public SpiderNest(){
     level=DEFAULT_LEVEL;
     location=DEFAULT_LOCATION;
     growthArea=DEFAULT_GROWTH_AREA;
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
