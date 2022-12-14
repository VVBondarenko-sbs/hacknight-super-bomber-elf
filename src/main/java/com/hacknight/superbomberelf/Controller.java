package com.hacknight.superbomberelf;

import com.hacknight.superbomberelf.client.MyWebSocketHandler;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@RestController
public class Controller {
  @Autowired
  private MyWebSocketHandler handler;

  @GetMapping("/left")
  public String moveLeft() throws IOException {
    session().sendMessage(new TextMessage("""
        {"command": "MoveWest"}
        """));
    return "left";
  }

  @GetMapping("/right")
  public String moveRight() throws IOException {
    session().sendMessage(new TextMessage("""
        {"command": "MoveEast"}
        """));
    return "right";
  }

  @GetMapping("/up")
  public String moveUp() throws IOException {
    session().sendMessage(new TextMessage("""
        {"command": "MoveNorth"}
        """));
    return "up";
  }

  @GetMapping("/down")
  public String moveDown() throws IOException {
    session().sendMessage(new TextMessage("""
        {"command": "MoveSouth"}
        """));
    return "down";
  }

  @GetMapping("/drop")
  public String dropBomb() throws IOException {
    session().sendMessage(new TextMessage("""
        {"command": "DropBomb"}
        """));
    return "drop";
  }

  @GetMapping("/look")
  public String look() throws IOException {
    session().sendMessage(new TextMessage("""
        {"command": "Look"}
        """));
    return "look";
  }

  @Scheduled(fixedDelay=5000)
  public void scheduledLook() throws IOException {
    look();
  }

  public WebSocketSession session() {
    return handler.getSession();
  }
}
