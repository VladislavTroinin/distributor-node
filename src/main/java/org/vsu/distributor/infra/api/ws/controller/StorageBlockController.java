package org.vsu.distributor.infra.api.ws.controller;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.vsu.distributor.app.service.StorageBlockService;

@Controller
@AllArgsConstructor
public class StorageBlockController {

    private final StorageBlockService storageBlockService;

    @MessageMapping("/blocks/get")
    public void getBlock(StompHeaderAccessor sha, @Payload String params) {
        storageBlockService.getStorageBlock(sha.getSessionId(), params);
    }

    @MessageMapping("/blocks/save")
    public void saveBlock(StompHeaderAccessor sha, @Payload String data) {
        storageBlockService.saveStorageBlock(sha.getSessionId(), data);
    }

}
