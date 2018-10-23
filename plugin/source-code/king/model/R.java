package king.model;

public final class R{

  public static final class def {
         
     public static final String MISSING_NAME_PREFIX="dimension";    
     public static final String NAME_LINK_CHAR="-";

     public static final String SPACE_SITE="site";
     public static final String SPACE_TYPE="type";
    
     public static final String RULE_YAML_TAG="R";
     public static final String DIMENSION_YAML_TAG="X";

     public static final String TAB="\t";

     public static final String EXTENSION_NAME="shspider";
     public static final String SPIDER_FILE_SUBFIX=".sh";
     public static final String GROW_FILE_PREFIX="_";
     public static final String GROW_FILE_SUBFIX="_grow";

     public static final String TASK_BORN_TEMP_DIR=".tmp";
     public static final String BORN_FILE_PREFIX="_";
     public static final String BORN_FILE_SUBFIX="_born";

     public static final int MIN_NAME_LENGTH=1;
     public static final int MAX_NAME_LENGTH=255;

     public static final String CONFIG_PATH_SEPARATOR="-";
     public static final String BLOCK_NEST="nest";

     public static final boolean FORHUMAN=true; 
     public static final String NEST_LOCATION="nest";
     public static final String NEST_GROWTH_AREA="growth";
     public static final String NEST_LEVEL="x";
         
     public static final String TASK_CLEAN="clean";
     public static final String TASK_ENVIRONMENT_CHECK="environmentCheck";
     public static final String TASK_BORN="born";
     public static final String TASK_GROW="grow";
     public static final String TASK_ADULT="adult";
     
     public static final String GROUP_SHELL_SPIDER="Shell Spider";
     public static final String TASK_CLEAN_DESCRIPTION="清理";
     public static final String TASK_ENVIRONMENT_CHECK_DESCRIPTION="环境检查";
     public static final String TASK_BORN_DESCRIPTION="蜘蛛孵化";
     public static final String TASK_GROW_DESCRIPTION="蜘蛛发育";
     public static final String TASK_ADULT_DESCRIPTION="成年";
  }

  public static final class tag {
     public static final String SCRIPT_HEAD="#!/usr/bin/env bash";
     public static final String AUTHOR="#作者:";
     public static final String EMAIL="#邮箱:";
     public static final String INTENT="#描述:";
     public static final String DATE="#日期:";
     public static final String VERSION="#版本:";
     public static final String SITE="#网址:";
  }
  
  public static final class var {
     public static final String ROOT="ROOT";
     public static final String REQUIREMENT="REQUIREMENT";
     public static final String CURL_OPTION="CURL_OPTION";
     public static final String SAVE_TYPE="SAVE_TYPE";
     public static final String SAVE_FILE="SAVE_FILE";
     public static final String SELF_UA="SELF_UA";
     public static final String PROCESS="PROCESS";
     public static final String RANGE="RANGE";
     public static final String LOG_FILE="LOG_FILE";
     public static final String LOG_LEVEL="LOG_LEVEL";
     public static final String LOG_STYLE="LOG_STYLE";
     public static final String VERSION="VERSION";
     public static final String INTENT="INTENT";
     public static final String CACHE="CACHE";
     public static final String RANGE_END="RANGE_END";
     public static final String RANGE_START="RANGE_START";
  }

  public static final class value {
     public static final String TOOL="curl sed ua awk";
     public static final String CURL_OPTION="-#";
     public static final String SAVE_TYPE=".html";
     public static final String RANGE="0:2";
     public static final String RANGE_START="0";
     public static final String RANGE_END="2";
     public static final int PROCESS=1;
     public static final int LOG_LEVEL=1;
     public static final String LOG_STYLE="middle";
     public static final String HTAB="  ";
     public static final String TAB=HTAB+HTAB;
     public static final String DTAB=TAB+TAB; 
  }
  
  public static final class file {
     public static final String FUNCTION="function"; 
  }
                                                              
  public static final class name {
     public static final String OUTPUT="output";
  }
 
  public static final class path {
     public static final String ROOT_DIR=".";                 
  }

  public static final class command {
    public static final String APP_START="app \"$#\" \"$*\"";
    public static final String SET_ROOT=var.ROOT+"="+path.ROOT_DIR;
    public static final String SET_REQUIREMENT=var.REQUIREMENT+"=\""+value.TOOL+"\"";
    public static final String SET_CURL_OPTION=var.CURL_OPTION+"=\""+value.CURL_OPTION+"\"";
    public static final String SET_SAVE_TYPE=var.SAVE_TYPE+"=\""+value.SAVE_TYPE+"\"";
    public static final String SET_SAVE_FILE=var.SAVE_FILE+"=\""+path.ROOT_DIR+"/"+name.OUTPUT+value.SAVE_TYPE+"\"";
    public static final String SET_SELF_UA=var.SELF_UA+"=0";
    public static final String SET_PROCESS=var.PROCESS+"="+value.PROCESS;
    public static final String SET_LOG_FILE=var.LOG_FILE+"=\"--\"";
    public static final String SET_LOG_LEVEL=var.LOG_LEVEL+"="+value.LOG_LEVEL;
    public static final String SET_LOG_STYLE=var.LOG_STYLE+"=\""+value.LOG_STYLE+"\"";
    public static final String SET_RANGE=var.RANGE+"=\""+value.RANGE+"\"";
    public static final String SET_CACHE=var.CACHE+"=0";
    public static final String SET_RANGE_HANDLE=var.RANGE_START+"="+value.RANGE_START+"\n"+var.RANGE_END+"="+value.RANGE_END;
  }

}
