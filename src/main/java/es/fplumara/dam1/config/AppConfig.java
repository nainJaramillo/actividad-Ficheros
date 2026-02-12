package es.fplumara.dam1.config;
import es.fplumara.dam1.exceptions.ConfigException;
import es.fplumara.dam1.files.StoreType;

import java.io.InputStream;
import java.nio.file.*;
import java.util.Properties;

public class AppConfig{
    private StoreType storeType;
    private String messagesFile;
    private int messagesMaxLength;

    public AppConfig(){
            try {
                Properties props = new Properties();
                Path path = Path.of("data/config.properties");
                InputStream in = Files.newInputStream(path);
                props.load(in);
                try{
                    storeType = StoreType.valueOf(String.valueOf(storeType));
                }catch (IllegalArgumentException e){
                    throw new ConfigException("No es valido");
                }

                messagesFile = props.getProperty("messages.file");
                if (storeType== null || messagesFile == null){
                    throw new ConfigException("No hay propiedades.");
                }
                String maxLengthStr = props.getProperty("message.maxLength");

                try{
                    messagesMaxLength = Integer.parseInt(maxLengthStr);
                }catch (Exception e){
                    messagesMaxLength = 100;
                }
        }catch (Exception ex){
                throw new ConfigException("ERROR AL LEER");
            }
    }

    public StoreType getStoreType() {
        return storeType;
    }

    public String getMessagesFile() {
        return messagesFile;
    }

    public int getMessagesMaxLength() {
        return messagesMaxLength;
    }
}


