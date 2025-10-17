package com.example.demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configurable
public class WebSokedConf {
    @Configuration
    @EnableWebSocketMessageBroker
    public class WsConfig implements WebSocketMessageBrokerConfigurer {
        @Override public void registerStompEndpoints(StompEndpointRegistry r) {
            r.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
        }
        @Override public void configureMessageBroker(MessageBrokerRegistry r) {

            r.enableSimpleBroker("/topic");
            r.setApplicationDestinationPrefixes("/app");


        }
    }


}

