package com.example.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    @GetMapping("/test")
    public void test(@RequestParam("message") String message) {
        sendMessage(message);
    }

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("baeldung", msg);
    }
}
//    public void sendMessage(String message) {
//        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("baeldung", message);//        future.whenComplete((result, ex) -> {
//            if (ex == null) {//                System.out.println("Sent message=[" + message +
//                        "] with offset=[" + result.getRecordMetadata().offset() + "]");//            } else {
//                System.out.println("Unable to send message=[" +//                        message + "] due to : " + ex.getMessage());
//            }//        });
//    }}