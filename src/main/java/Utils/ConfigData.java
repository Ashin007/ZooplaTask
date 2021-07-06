package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigData {



    public static String getPropertiesData(String keyword) throws IOException {


        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Utils\\config.properties");
        properties.load(fileInputStream);
        return properties.getProperty(keyword);
    }
}
