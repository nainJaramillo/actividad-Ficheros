package es.fplumara.dam1.config;
import es.fplumara.dam1.exceptions.ConfigException;

import java.io.InputStream;
import java.nio.file.*;
import java.util.Properties;

public class AppConfig{
    private String storeType;
    private String messagesFile;
    private int messagesMaxLength;

    public AppConfig(){
            try {
                Properties props = new Properties();
                Path path = Path.of("config.properties");
                InputStream in = Files.newInputStream(path);
                props.load(in);
                storeType  = props.getProperty("store.type");
                messagesFile = props.getProperty("messages.file");
                messagesMaxLength = Integer.parseInt(props.getProperty("messages.maxLength"));
            }catch(Exception ex){
                throw new ConfigException("No se puede encontrar el archivo data/config.properties");

            }
        }

}
