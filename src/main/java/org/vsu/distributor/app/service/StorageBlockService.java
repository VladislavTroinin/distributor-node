package org.vsu.distributor.app.service;

import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StorageBlockService {

    private final UserService userService;
    private final SimpMessagingTemplate messagingTemplate;

    public void getStorageBlock(String sessionId, String params) {
        // todo
    }

    public void saveStorageBlock(String sessionId, String data) {
        // todo
    }

}
