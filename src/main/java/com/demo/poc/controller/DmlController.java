package com.demo.poc.controller;

import com.demo.poc.entity.Insert;
import com.demo.poc.service.demoservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class DmlController {

  @Autowired
  private demoservice demoService;

  @PostMapping("/insertData")
  public String insertData(@RequestBody Insert data) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      demoService.insertData(data);
    }
    catch (Exception e) {
      return e.getMessage();
    }
    return objectMapper.writeValueAsString("Data Inserted Successfuly");
  }

  @GetMapping("/viewData/{tableName}")
  public String viewData(@PathVariable("tbname") String tableName) throws Exception {
      return demoService.viewData(tableName);
  }

  @GetMapping("/listAllTables")
  public String listTables() throws Exception {
    return demoService.listTables();
  }

  @GetMapping(path="/viewSchema/{tableName}")
  public String viewSchema(@PathVariable("tableName") String tableName) throws Exception {
    return demoService.viewSchema(tableName);
  }
}
