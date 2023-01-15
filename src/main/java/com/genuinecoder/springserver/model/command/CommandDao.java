package com.genuinecoder.springserver.model.command;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class CommandDao {

  @Autowired
  private CommandRepository repository;

  public Command save(Command cmd) {
    return repository.save(cmd);
  }

  public List<Command> getAllCommands() {
    List<Command> commands = new ArrayList<>();
    Streamable.of(repository.findAll())
        .forEach(commands::add);
    return commands;
  }

  public void delete(int commandId) {
    repository.deleteById(commandId);
  }
}
