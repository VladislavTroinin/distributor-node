package org.vsu.distributor.app.service;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.vsu.distributor.app.provider.MessageProvider;

@Service
@AllArgsConstructor
public class MigrationService {

    private final UserService userService;
    private final MessageProvider messageProvider;

    public void shareData() {
        // todo
    }

    public void mergeData() {
        // todo
    }

}
