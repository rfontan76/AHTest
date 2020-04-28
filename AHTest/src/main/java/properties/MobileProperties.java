package properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class MobileProperties {

    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");
    static String envProps = projectPath + "/src/main/resources/environment.properties";
    static String configProps= setDUT();


    public static String setDUT() {
        try {
            InputStream input = new FileInputStream(envProps);
            prop.load(input);

            if(prop.getProperty("dut").equalsIgnoreCase("emulator")){
                configProps = projectPath + "/src/main/resources/emulator.properties";
            }
            if(prop.getProperty("dut").equalsIgnoreCase("phone")){
                configProps = projectPath + "/src/main/resources/mobile.properties";
            }else {
                System.out.println("You device under test in environment.properties is neither 'emulator' or phone\n" +
                        "Please review and update to execute the tests successfully");
            }
        }catch (Exception exp) {
            System.out.print(exp.getMessage());
            System.out.print(exp.getCause());
            exp.printStackTrace();
        }
        return configProps;

    }


    //Get Property: Version
    public static String getVersion () {
        try {
            InputStream input = new FileInputStream(configProps);
            prop.load(input);

        } catch (Exception exp) {
            System.out.print(exp.getMessage());
            System.out.print(exp.getCause());
            exp.printStackTrace();
        }

        return prop.getProperty("version");
    }


    //Get Property: Device
    public static String getDevice () {
        try {
            InputStream input = new FileInputStream(configProps);
            prop.load(input);

        } catch (Exception exp) {
            System.out.print(exp.getMessage());
            System.out.print(exp.getCause());
            exp.printStackTrace();
        }
        return prop.getProperty("device");
    }
}