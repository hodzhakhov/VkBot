package ru.hodzhakhov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hodzhakhov.dao.models.Event;
import ru.hodzhakhov.services.BotService;

@RestController
@RequestMapping("")
public class BotController {
  private final BotService botService;

  @Autowired
  public BotController(BotService botService) {
    this.botService = botService;
  }

  @PostMapping("")
  public String confirmation(@RequestBody Event event) {
    return botService.action(event);
  }
}
