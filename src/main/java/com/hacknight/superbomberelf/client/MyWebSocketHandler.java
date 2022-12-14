package com.hacknight.superbomberelf.client;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

@Component
public class MyWebSocketHandler implements WebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println(message.getPayload());

        session.sendMessage(new TextMessage("""
                {
                      "command": [
                        "SetName",
                        "java lads"
                      ]
                    }
                """));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
