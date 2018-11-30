package com.demo.poc.dao;

import com.demo.poc.entity.Create;
import com.demo.poc.entity.Insert;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.SQLException;
import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class demodaoImpl implements demodao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void createTable(Create tbdetails) throws SQLException {
    String sql = "CREATE TABLE IF NOT EXISTS " + tbdetails.getTbname() + " ( ";
    tbdetails.getColumns().forEach((k,v)->{System.out.println("Key is:-"+k+"Value is:-"+v);});
    for (Map.Entry<String,String> m : tbdetails.getColumns().entrySet()){
      sql += m.getKey() + " " + m.getValue() + ",";
    }
    sql = sql.substring(0,sql.length() - 1) + " );";
    System.out.println(sql);
    jdbcTemplate.execute(sql);
  }

  @Override
  public void insertData(Insert data) throws SQLException {
    String sql = "INSERT INTO " + data.getTbname() + "( ";
    for (Map.Entry<String,String> m : data.getData().entrySet()){
      sql += m.getKey() + ",";
    }
    sql = sql.substring(0,sql.length() - 1) + ") VALUES (";
    for (Map.Entry<String,String> m : data.getData().entrySet()){
      sql += "'" + m.getValue() + "',";
    }
    sql = sql.substring(0,sql.length() - 1) + ");";
    System.out.println(sql);
    jdbcTemplate.execute(sql);
  }

  public String viewData(String tbname) throws Exception {
    String sql = " SELECT * FROM " + tbname;
    List<Map<String,Object>> result =  jdbcTemplate.queryForList(sql);

    ObjectMapper objectMapper = new ObjectMapper();

    return objectMapper.writeValueAsString(result);
  }

  public void deleteTable(String tbname) throws SQLException {
    String sql = " DROP TABLE " + tbname;
    jdbcTemplate.execute(sql);
  }

  public String listTables() throws Exception {
    String sql = "SHOW tables";
    List<Map<String, Object>> result=jdbcTemplate.queryForList(sql);
    List<Object> listOfTables=new ArrayList<>();
    for(Map<String, Object> map:result)
    {
      listOfTables.add(map.get("Tables_in_rohan"));
    }
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(listOfTables);
  }

  public String viewSchema(String tbname) throws Exception {
    String sql = "DESCRIBE " + tbname;
    List<Map<String,Object>> result = jdbcTemplate.queryForList(sql);

    ObjectMapper objectMapper = new ObjectMapper();

    return objectMapper.writeValueAsString(result);
  }
}
