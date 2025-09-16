package com.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public void saveOrder(Order orderToSave) {
        //saving to DB...
        //send to kafka
        log.info("Order successfully saved: id={}", orderToSave.orderId());
    }
}
