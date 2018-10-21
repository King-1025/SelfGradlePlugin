package king.model;

import com.google.common.base.Objects;

import org.gradle.api.Named;
import org.gradle.api.Incubating;

import king.model.SpiderDescriptor;
import king.model.SpiderFeature;
import king.model.ExtensionModel;
import king.model.Space;
import king.model.R;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Map;

import groovy.lang.Closure;

public class Spider extends ExtensionModel implements Named,Serializable {
  private final String name;
  private String id;
  private String[] master;
  private boolean forHuman=R.def.FORHUMAN;
  private SpiderDescriptor description=new SpiderDescriptor();
  private SpiderFeature feature=new SpiderFeature();
  private Map<String,Space> predationArea;

  private String tempDir;
  private String tempFilePath;
  
  public Spider(String name){
     this.name=name;
  }
 
  public String getName(){
     return name;
  }

  public String getId(){
      return id;
  }
  
  public void setId(String id){
      this.id=id;
  }
  
  public boolean getForHuman(){
      return forHuman;
  }
  
  public void setForHuman(boolean forHuman){
      this.forHuman=forHuman;
  }
  
  @Nullable
  public SpiderDescriptor getDescription(){
      return description;
  }

  public void description(Closure closure){
      configure(description,closure);
  }

  @Nullable
  public SpiderFeature getFeature(){
      return feature;
  }
  
  public void feature(Closure closure){
      configure(feature,closure);
  }
  
  @Nullable
  public String[] getMaster(){
       return master;
  }
 
  public void setMaster(String[] master){
       this.master=master;
  }

  public Map<String,Space> getPredationArea(){
       return predationArea;
  }
  
  public void setPredationArea(Map<String,Space> predationArea){
       this.predationArea=predationArea;
  }
 
  public String getTempDir(){
       return tempDir;
  }

  public void setTempDir(String tempDir){
       this.tempDir=tempDir;
  }

  public String getTempFilePath(){
       return tempFilePath;
  }

  public void setTempFilePath(String tempFilePath){
       this.tempFilePath=tempFilePath;
  }

  public boolean equals(Object object){
      if(object instanceof Spider){
         Spider other=(Spider)object;
         return Objects.equal(name,other.name)
             && Objects.equal(id,other.id);
      }
      return false;
  }
 
  public int hashCode(){
      return Objects.hashCode(name,id);
  }
}
