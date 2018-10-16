package king.model;

public class SpiderDescriptor{
   private String intent;
   private String author;
   private String email;
   private String weburl;
   private String date;
   
   public SpiderDescriptor(){

   } 
   
   public String getIntent(){
      return intent;
   }

   public void setIntent(String intent){
      this.intent=intent;
   }

   public String getAuthor(){
      return author;
   }

   public void setAuthor(String author){
      this.author=author;
   }
   
   public String getEmail(){
      return email;
   }

   public void setEmail(String email){
      this.email=email;
  }

   public String getWeburl(){
      return weburl;
   }

   public void setWeburl(String weburl){
      this.weburl=weburl;
   }
   
   public String getDate(){
      return date;
   }

   public void setDate(String date){
      this.date=date;
   }
}
