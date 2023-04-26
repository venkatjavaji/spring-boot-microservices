package com.test.pushnotification.service;

import com.test.pushnotification.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Qualifier("emitterService")
public class EmitterService {

    List<SseEmitter> emitters = new ArrayList<>();

    public void addEmitter(SseEmitter emitter) {
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        emitter.onError(e -> {
            log.error("Create SseEmitter exception", e);
            emitters.remove(emitter);
        });
        try {
            emitter.send(SseEmitter.event().name("subscribe"));
        } catch (IOException e) {
            log.error("Subscription error. error = " + e.getMessage());
        }
        emitters.add(emitter);
    }

    public void pushNotification(String username, String name, String message) {
        log.info("pushing {} notification for user {}", message, username);
        List<SseEmitter> deadEmitters = new ArrayList<>();

        Notification payload = Notification
                .builder()
                .from(name)
                .message(message)
                .build();

        emitters.forEach(emitter -> {
            try {
                emitter.send(SseEmitter
                        .event()
                        .name(username)
                        .data(payload));

            } catch (IOException e) {
                deadEmitters.add(emitter);
            }
        });

        emitters.removeAll(deadEmitters);
    }
}
