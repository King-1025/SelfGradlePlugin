package king.model;

public class Rule{
  private String tag;
  private String type;
  private String action;
  private String profile;
  private String mode;

  public static final String TYPE_TEXT="TEXT";
  public static final String TYPE_URL="URL";
  public static final String TYPE_VIDEO="VIDEO";
  public static final String TYPE_IMAGE="IMAGE";
  public static final String TYPE_MUSIC="MUSIC";
 
  public static final String MODE_UNIQUE="UNIQUE";
  public static final String MODE_ARRAY="ARRAY";

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

  public String getProfile(){
      return profile;
  }

  public void setProfile(String profile){
      this.profile=profile;
  }

  public String getMode(){
      return mode;
  }

  public void setMode(String mode){
      this.mode=mode;
  }
}
