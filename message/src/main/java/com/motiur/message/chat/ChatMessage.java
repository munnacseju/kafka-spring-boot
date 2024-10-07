package com.motiur.message.chat;

import lombok.*;

/**
 * User: munna, Software Engineer
 * Date: 10/7/24
 * Time: 11:06 AM
 * Class Name: ChatMessage
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private String content;
    private String sender;
    private Type type;
}
