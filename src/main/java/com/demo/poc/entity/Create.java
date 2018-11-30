package com.demo.poc.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Create implements Serializable {

  private String tbname;
  private HashMap<String,String> columns;

  public Create(String tbname, HashMap<String, String> columns) {
    this.tbname = tbname;
    this.columns = columns;
  }

  public String getTbname() {
    return tbname;
  }

  public void setTbname(String tbname) {
    this.tbname = tbname;
  }

  public Map<String, String> getColumns() {
    return columns;
  }

  public void setColumns(HashMap<String, String> columns) {
    this.columns = columns;
  }

  public Create(){
  }

}
