package es.ieslavereda.propierties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MyConfig {
    private static MyConfig instance;
    private static String DEFAULT_PROPERTIES = "default.properties";
    private static String CUSTOM_PROPERTIES = "custom.properties";
    private Properties appProperties;

    private MyConfig() {
        Properties defaultProperties = new Properties();

        try(FileInputStream fis = new FileInputStream(DEFAULT_PROPERTIES)) {
            defaultProperties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        appProperties = new Properties(defaultProperties);

        try(FileInputStream fis = new FileInputStream(CUSTOM_PROPERTIES)) {
            appProperties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(){
        try(FileOutputStream fos = new FileOutputStream(CUSTOM_PROPERTIES)) {
            appProperties.store(fos,"UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MyConfig getInstance(){
        if (instance==null){
            instance = new MyConfig();
        }
        return instance;
    }

    public String getUsername(){
        return appProperties.getProperty("USERNAME");
    }

    public String getPassword(){
        return appProperties.getProperty("PASSWORD");
    }

    public void setPassword(String pass){
        appProperties.setProperty("PASSWORD",pass);
    }

    public String getDBHostora(){
        return appProperties.getProperty("DB_HOST");
    }

    public String getDBPortora(){
        return appProperties.getProperty("DB_PORT");
    }

    public String getDBSchemaora(){
        return appProperties.getProperty("DB_SCHEMA");
    }
}
