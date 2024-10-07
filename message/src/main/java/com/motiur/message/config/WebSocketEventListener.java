package com.motiur.message.config;

import com.motiur.message.chat.ChatMessage;
import com.motiur.message.chat.Type;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * User: munna, Software Engineer
 * Date: 10/7/24
 * Time: 11:03 AM
 * Class Name: WebSocketEventListener
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageSendingOperations;

    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String userName = (String) headerAccessor.getSessionAttributes().get("username");
        if(userName != null){
            log.info("User disconnected : {}", userName);
            var chatMessage = ChatMessage.builder()
                    .type(Type.LEAVE)
                    .sender(userName)
                    .build();
            messageSendingOperations.convertAndSend("/topic/public", chatMessage);
        }
        //TODO ..............
    }
}
