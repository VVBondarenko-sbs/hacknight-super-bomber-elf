package com.hacknight.superbomberelf.client;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class MyWebSocketHandler implements WebSocketHandler {
    private AtomicReference<WebSocketSession> sessionRef = new AtomicReference<>();

    public WebSocketSession getSession() {
        return sessionRef.get();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        if (sessionRef.get() == null)
            sessionRef.set(session);
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
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println(message.getPayload());
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
