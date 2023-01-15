package com.genuinecoder.springserver.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.genuinecoder.springserver.model.command.Command;
import com.genuinecoder.springserver.model.command.CommandDao;
import com.genuinecoder.springserver.model.command.User;
import com.genuinecoder.springserver.model.command.UserRowMapper;

@RestController
public class CommandController {

  @Autowired
  private CommandDao commandDao;

  @GetMapping("/command/get-all")
  public List<Command> getAllCommands() {
    return commandDao.getAllCommands();
  }

  @PostMapping("/command/save")
  public Command save(@RequestBody Command employee) {
    return commandDao.save(employee);
  }
  
  @Autowired
  private JdbcTemplate jdbcTemplate;



  @PostMapping("/checkCredits")
  public boolean CheckCredits(@RequestBody User user) {

      try {
          String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
          User user2 = jdbcTemplate.queryForObject(sql, new Object[] {user.getUsername(), user.getPassword()}, new UserRowMapper());


          System.out.println("-------------------- user found !!!");
          return true;


      } catch (IncorrectResultSizeDataAccessException e) {
          System.out.println("-------------------- user not found !!!");
          return false;
      }

  }
}
