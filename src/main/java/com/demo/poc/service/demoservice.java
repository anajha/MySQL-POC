package com.demo.poc.service;

import com.demo.poc.dao.demodao;
import com.demo.poc.entity.Create;
import com.demo.poc.entity.Insert;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class demoservice {

  @Autowired
  private demodao demoDao;

  public void createTable(Create tbdetails) throws SQLException {
    demoDao.createTable(tbdetails);
  }

  public void insertData(Insert data) throws SQLException {
    demoDao.insertData(data);
  }

  public String viewData(String tbname) throws Exception {
    return demoDao.viewData(tbname);
  }

  public void deleteTable(String tbname) throws SQLException {
    demoDao.deleteTable(tbname);
  }

  public String listTables() throws Exception {
    return demoDao.listTables();
  }

  public String viewSchema(String tbname) throws Exception {
    return demoDao.viewSchema(tbname);
  }
}
