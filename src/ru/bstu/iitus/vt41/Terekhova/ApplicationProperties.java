package ru.bstu.iitus.vt41.Terekhova;


import com.sun.corba.se.impl.orbutil.closure.Constant;
import ru.bstu.iitus.vt41.Terekhova.enums.PathFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
    private static ApplicationProperties ourInstance = new ApplicationProperties();
    private static Properties properties;

    public static ApplicationProperties getInstance() {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(PathFile.FILE_PROPERTIES.filePath));
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException ("Файл не найден");
        }

        return ourInstance;
    }

    public String getProperty (String propertyKey) {
        return properties.getProperty(propertyKey);
    }


    private ApplicationProperties() {
    }
}
