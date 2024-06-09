package org.vsu.distributor.infra.api.ws.provider;

import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.vsu.distributor.app.provider.MessageProvider;

@Component
@AllArgsConstructor
public class WebSocketMessageProvider implements MessageProvider {

    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public void send(String userId, String destination, Object payload) {
        messagingTemplate.convertAndSend(destination + "/" + userId, payload);
    }

}
