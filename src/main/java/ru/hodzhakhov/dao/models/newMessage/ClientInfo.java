package ru.hodzhakhov.dao.models.newMessage;

import java.util.List;
import lombok.Data;

@Data
public class ClientInfo {
  List<String> button_actions;
  boolean keyboard;
  boolean inline_keyboard;
  boolean carousel;
  int lang_id;
}
