package com.hacknight.superbomberelf.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.net.URI;

@Configuration
public class WebSocketClientBeans {

    @Bean
    public WebSocketClient webSocketClient(final WebSocketHandler webSocketHandler) {
        final var wsClient = new StandardWebSocketClient();
        wsClient.doHandshake(webSocketHandler, new WebSocketHttpHeaders(), URI.create("ws://172.16.173.86:8080"));
        return wsClient;
    }

}
