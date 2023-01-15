package com.genuinecoder.springserver;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.genuinecoder.springserver.model.command.Command;
import com.genuinecoder.springserver.model.command.CommandDao;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class SpringServerApplicationTests {

  private CommandDao employeeDao;

  @Test
  void addEmployeeTest() {
    addEmployee("Bruce Wayne", "Building-X", "Security");
    addEmployee("Harvey Dent", "Building-2", "Police");
    addEmployee("Rachel", "Building-11", "IT");
  }

  private void addEmployee(String name, String description, String prix) {
    Command employee = new Command();
    employee.setName(name);
    employee.setDescription(description);
    employee.setPrix(prix);
    employeeDao.save(employee);
  }

}
