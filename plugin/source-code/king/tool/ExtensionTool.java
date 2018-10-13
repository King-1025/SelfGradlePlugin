package king.tool;

import org.gradle.api.plugins.ExtensionAware;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.Project;

import king.extension.ShellSpiderExtension;

public class ExtensionTool{
    
    private ExtensionTool(){
      
    }

    public static <T> T maybeCreateForShellSpider(Project project, String name, Class<T> type, Object... args) {
        ShellSpiderExtension extension = getShellSpiderExtension(project);
        return maybeCreate(extension, name, type, args);
    }
  
   public static <T> T maybeCreate(Object extension, String name, Class<T> type, Object... args) {
        ExtensionContainer extensionContainer = ((ExtensionAware) extension).getExtensions();
        T maybeExtension = extensionContainer.findByType(type);
        if (maybeExtension == null) {
            maybeExtension = extensionContainer.create(name, type, args);
        }
        return maybeExtension;
   }

    public static ShellSpiderExtension getShellSpiderExtension(Project project) {
        return project.getExtensions().getByType(ShellSpiderExtension.class);
    }
}
