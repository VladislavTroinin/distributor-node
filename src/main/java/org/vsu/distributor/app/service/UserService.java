package org.vsu.distributor.app.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

@Service
public class UserService {

    private final Map<String, String> sessionUserMapping;

    public UserService() {
        this.sessionUserMapping = Collections.synchronizedMap(new HashMap<>());
    }

    public String getUserId(String sessionId) {
        return sessionUserMapping.get(sessionId);
    }

//    public TreeMap<String, String> getAddressMapping() {
//        return new TreeMap<>();     // todo
//    }

    public void add(String sessionId, String userId) {
        sessionUserMapping.put(sessionId, userId);
    }

    public void remove(String sessionId) {
        sessionUserMapping.remove(sessionId);
    }

}
