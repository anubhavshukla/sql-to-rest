package com.provisiontree.sqltorest.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("{tableName}")
public class TableController {

  @RequestMapping(method = RequestMethod.GET)
  public String list() {
    System.out.println("Inside test method");
    return "test String";
  }

}
