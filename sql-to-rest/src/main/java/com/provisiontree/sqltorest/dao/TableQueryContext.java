package com.provisiontree.sqltorest.dao;

import java.util.HashMap;
import java.util.Map;

public class TableQueryContext {

  private String tableName;

  private Map<String, String> filterMap = new HashMap<String, String>();

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public void addFilter(String columnName, String value) {
    filterMap.put(columnName, value);
  }

  public Map<String, String> getFilters() {
    return filterMap;
  }
}
