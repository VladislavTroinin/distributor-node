package org.vsu.distributor.app.provider;

public interface MessageProvider {

    void send(String sessionId, String destination, Object payload);

}
