package com.demo.poc.entity;

import java.util.Map;

public class Insert {
    private String tbname;
    private Map<String,String> data;

  public Insert(String tbname, Map<String, String> data) {
    this.tbname = tbname;
    this.data = data;
  }

  public String getTbname() {
    return tbname;
  }

  public void setTbname(String tbname) {
    this.tbname = tbname;
  }

  public Map<String, String> getData() {
    return data;
  }

  public void setData(Map<String, String> data) {
    this.data = data;
  }

  public Insert(){
  }
}
