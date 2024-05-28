package ru.hodzhakhov.dao.models;

import lombok.Data;
import ru.hodzhakhov.dao.models.newMessage.NewMessage;

@Data
public class Event {
  String type;
  String event_id;
  String v;
  int group_id;
  NewMessage object;
}
