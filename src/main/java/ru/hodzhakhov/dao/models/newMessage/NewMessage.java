package ru.hodzhakhov.dao.models.newMessage;

import lombok.Data;

@Data
public class NewMessage {
  ClientInfo client_info;
  Message message;
}
