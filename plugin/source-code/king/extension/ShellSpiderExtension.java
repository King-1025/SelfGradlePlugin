package king.extension;

import org.gradle.api.Project;
import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;

import king.model.SpiderNest;
import king.model.Spider;
import king.model.Space;

public class ShellSpiderExtension extends BasedExtension{
   private SpiderNest nest;
   private final NamedDomainObjectContainer<Spider> spiders;
   private final NamedDomainObjectContainer<Space> web;
   private final static String BLOCK_NEST="nest";
   
   public ShellSpiderExtension(Project project){
         setProject(project);
         this.nest=block(BLOCK_NEST,SpiderNest.class);
         this.spiders=getProject().container(Spider.class);
         this.web=getProject().container(Space.class);
   }
   
   public SpiderNest getNest(){
         return nest;
   }
   
   public NamedDomainObjectContainer<Spider> getSpiders(){
         return spiders;
   }

   public NamedDomainObjectContainer<Space> getWeb(){
         return web;
   }

   public void spiders(Action<? super NamedDomainObjectContainer<Spider>> action){
         action.execute(spiders);
   }

   public void web(Action<? super NamedDomainObjectContainer<Space>> action){
        action.execute(web);
  }
}
