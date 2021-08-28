package com.shamigh.Auth.WebSocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/*
On crée une classe de configuration qui hérite de WebSocketMessageBrokerConfigurer.
Les appels qui utilisent le protocole Websocket seront alors dirigés vers
les endpoints (points de connexion) dédiés.
 */

@Configuration
@EnableWebSocketMessageBroker
@CrossOrigin("http://localhost:4200")
public class WsConfig implements WebSocketMessageBrokerConfigurer {

    // on définit donc deux préfixes pour filtrer les destinations
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app")
                .enableSimpleBroker("/socket");
    }

    /*
    on ajoute le point d’entrée pour le handshake : c’est une requête HTTP ayant dans son header,
    l’option Upgrade qui demande au serveur de se servir dorénavant du protocole Websocket.
    Le protocole HTTP sera utilisé uniquement ici, pour l’ouverture de la connexion
     */
    @Override public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/socket")
                .setAllowedOrigins("http://localhost:4200")
                .withSockJS();
    }
}
