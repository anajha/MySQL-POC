package com.demo.poc.dao;

import com.demo.poc.entity.Create;
import com.demo.poc.entity.Insert;
import java.sql.SQLException;

public interface demodao {
    void createTable(Create tbdetails) throws SQLException;

    void insertData(Insert data) throws SQLException;

    String viewData(String tbname) throws Exception;

    void deleteTable(String tbname) throws SQLException;

    String listTables() throws Exception;

    String viewSchema(String tbname) throws Exception;
}
