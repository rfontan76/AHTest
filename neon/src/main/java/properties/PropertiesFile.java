package properties;

import base.BaseDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");

    public static void getBrowserType (){
        try {
            InputStream input = new FileInputStream(projectPath + "/src/main/java/properties/config.properties");
            prop.load(input);
            String browser = prop.getProperty("browser");
            BaseDriver.browserName = browser;

        }catch(Exception exp){
            System.out.print(exp.getMessage());
            System.out.print(exp.getCause());
            exp.printStackTrace();
        }

    }
}