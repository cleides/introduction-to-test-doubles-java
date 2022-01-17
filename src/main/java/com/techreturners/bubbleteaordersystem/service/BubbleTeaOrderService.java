package com.techreturners.bubbleteaordersystem.service;

import com.techreturners.bubbleteaordersystem.model.SimpleLoggerImpl;
import com.techreturners.bubbleteaordersystem.model.BubbleTeaOrderRequest;
import com.techreturners.bubbleteaordersystem.model.BubbleTeaRequest;

public class BubbleTeaOrderService {

    private SimpleLoggerImpl simpleLogger;
    private BubbleTeaMessenger bubbleTeaMessenger;
    // Injection is when are given helper objects in the constructor, also called dependency injection DI.
    // BubbleTeaMessenger and SimpleLoggerImpl classes names are injected into our constructor.
    public BubbleTeaOrderService(SimpleLoggerImpl simpleLogger, BubbleTeaMessenger bubbleTeaMessenger) {
        this.simpleLogger = simpleLogger;
        this.bubbleTeaMessenger = bubbleTeaMessenger;
    }

    public BubbleTeaOrderRequest createOrderRequest(BubbleTeaRequest bubbleTeaRequest) {

        simpleLogger.addLoggingText("Creating an Order Request for the " +
                "following Bubble Tea Request " + bubbleTeaRequest.toString());

        var orderRequest = new BubbleTeaOrderRequest(
                bubbleTeaRequest.getPaymentDetails().getName(),
                bubbleTeaRequest.getPaymentDetails().getAddress(),
                bubbleTeaRequest.getPaymentDetails().getDebitCard().getDigits(),
                bubbleTeaRequest.getBubbleTea().getBubbleTeaType()
        );

        simpleLogger.addLoggingText("The following Bubble Tea Order Request has been created "
                + orderRequest.toString());

        sendEmail(orderRequest);

        return orderRequest;

    }

    private void sendEmail(BubbleTeaOrderRequest bubbleTeaOrderRequest) {
        bubbleTeaMessenger.sendBubbleTeaOrderRequestEmail(bubbleTeaOrderRequest);
    }

}
