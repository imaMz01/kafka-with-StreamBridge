package com.streamBridge.producer.Controller;

import com.streamBridge.producer.Payload.User;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/producer")
public class producerController {

    private final StreamBridge streamBridge;

    @PostMapping
    public String  sendUser(@RequestBody User user){
        user.setId(UUID.randomUUID().toString());
        streamBridge.send("user-topic",user);
        return "the user with id : "+user.getId()+" is sent";
    }
}
