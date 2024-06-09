package org.vsu.distributor.infra.api.ws.listener;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.vsu.distributor.app.service.MigrationService;
import org.vsu.distributor.app.service.UserService;

@Component
@AllArgsConstructor
public class ConnectionListener {

    private final UserService userService;
    private final MigrationService migrationService;

    @MessageMapping("/connection")
    public void handleConnection(StompHeaderAccessor sha, @Payload String userId) {
        String sessionId = sha.getSessionId();
        userService.add(sessionId, userId);
        migrationService.shareData();
    }

    @EventListener
    public void handleWebSocketDisconnect(SessionDisconnectEvent event) {
        userService.remove(event.getSessionId());
        migrationService.mergeData();
    }

}
