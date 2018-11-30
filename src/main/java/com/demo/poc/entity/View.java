package com.demo.poc.entity;

import java.util.List;

public class View {
  private String tbname;
  private List<String> columns;

  public String getTbname() {
    return tbname;
  }

  public void setTbname(String tbname) {
    this.tbname = tbname;
  }

  public List<String> getColumns() {
    return columns;
  }

  public void setColumns(List<String> columns) {
    this.columns = columns;
  }

  public View(String tbname, List<String> columns) {
    this.tbname = tbname;
    this.columns = columns;
  }
}
