package king.model;

public class SpiderNest{
  private String name;
  private String level;
  private String location;
  private String growthArea;
  
  private final static String DEFAULT_LOCATION="nest";
  private final static String DEFAULT_GROWTH_AREA="growth";
  public SpiderNest(){
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
