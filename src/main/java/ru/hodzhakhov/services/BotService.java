package ru.hodzhakhov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.hodzhakhov.dao.models.Event;
import ru.hodzhakhov.dao.models.response.Response;

@Service
public class BotService {
  @Value("${confirmation}")
  private String confirmationString;

  @Value("${access.token}")
  private String accessToken;

  private final WebClient webClient;

  @Autowired
  public BotService(WebClient webClient) {
    this.webClient = webClient;
  }

  public String action(Event event) {
    String answer = "";
    if (event.getType().equals("confirmation")) {
      answer = confirmationString;
    } else if (event.getType().equals("message_new")) {
      int userId = event.getObject().getMessage().getFrom_id();
      String message = "Ваше сообщение: " + event.getObject().getMessage().getText();
      String v = event.getV();

      Response response =
          this.webClient
              .post()
              .uri(
                  String.join(
                      "",
                      "?access_token=",
                      accessToken,
                      "&user_id=",
                      Integer.toString(userId),
                      "&random_id=0",
                      "&peer_id=",
                      Integer.toString(userId),
                      "&message=",
                      message,
                      "&v=",
                      v))
              .retrieve()
              .bodyToMono(Response.class)
              .block();

      answer = "Ok";
    }
    return answer;
  }
}
