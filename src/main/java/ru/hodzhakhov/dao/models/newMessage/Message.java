package ru.hodzhakhov.dao.models.newMessage;

import java.util.List;
import lombok.Data;

@Data
public class Message {
  int date;
  int from_id;
  int id;
  int out;
  int version;
  List<String> attachments;
  int conversation_message_id;
  List<String> fwd_messages;
  boolean important;
  boolean is_hidden;
  int peer_id;
  int random_id;
  String text;
  boolean is_mentioned_user;
}
