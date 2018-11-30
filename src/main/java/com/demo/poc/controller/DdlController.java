package com.demo.poc.controller;

import com.demo.poc.entity.Create;
import com.demo.poc.service.demoservice;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class DdlController {

    @Autowired
    private demoservice demoService;

    @PostMapping("/create")
    public String createTable(@RequestBody Create tableDetails) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            demoService.createTable(tableDetails);
        }
        catch (Exception e) {
            return e.getMessage();
        }
        return objectMapper.writeValueAsString("Table Created Successfully");
    }

    @DeleteMapping("/deleteTable/{tableName}")
    public String  deleteTable(String tableName) throws SQLException,JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            demoService.deleteTable(tableName);
        }
        catch (Exception e) {
            return e.getMessage();
        }
        return objectMapper.writeValueAsString("Table Deleted Successfully");
    }
}
