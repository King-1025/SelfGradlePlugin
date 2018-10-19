package king.model;

public class Rule{
  private String tag;
  private String type;
  private String action;

  public static final String TYPE_TEXT="TEXT";
  public static final String TYPE_URL="URL";
 
  public String getTag(){
      return tag;
  } 
  
  public void setTag(String tag){
      this.tag=tag;
  }

  public String getType(){
      return type;
  }

  public void setType(String type){
      this.type=type;
  }

  public String getAction(){
      return action;
  }

  public void setAction(String action){
      this.action=action;
  }
}
