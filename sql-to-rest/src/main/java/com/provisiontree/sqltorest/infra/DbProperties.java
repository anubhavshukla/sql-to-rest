package com.provisiontree.sqltorest.infra;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbProperties {

  public enum Key {
    
    DBNAME("dbname"), HOSTNAME("dbname"), PORT("dbname"), DRIVERCLASS("dbname"), USERNAME(
        "dbname"), PASSWORD("dbname");

    private String propertiesFileKey;

    private Key(String fileKey) {
      propertiesFileKey = fileKey;
    }

    public String toString() {
      return propertiesFileKey;
    }
  }

  private static final String DB_CONFIG_FILE = "dbconfig.properties";

  private Properties dbProperties = new Properties();

  {
    InputStream inputStream = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream(DB_CONFIG_FILE);
    try {
      dbProperties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Properties getAllProperties() {
    return dbProperties;
  }

  public String getProperty(Key key) {
    return dbProperties.getProperty(key.toString());
  }

  public String getDbName() {
    return getProperty(Key.DBNAME);
  }
}
