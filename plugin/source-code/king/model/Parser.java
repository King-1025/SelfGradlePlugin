package king.model;

import java.util.List;

import king.model.Space;

public interface Parser{
   public String genCrawlFunction(Space space);
   public List<String>listFunctionName();
}
