package io.apitestbase.demo.samplejmsservices;

import jakarta.jms.JMSException;
import jakarta.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class EchoService {
    @Value("${echo.service.output.queue.name}")
    private String outputQueueName;

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "${echo.service.input.queue.name}")
    public void echo(TextMessage request) throws JMSException {
        System.out.println("Received: " + messageToString(request));

        AtomicReference<TextMessage> reply = new AtomicReference<>();
        jmsTemplate.send(outputQueueName, session -> {
            reply.set(session.createTextMessage());
            reply.get().setText(request.getText());
            reply.get().setJMSCorrelationID(request.getJMSCorrelationID());
            reply.get().setStringProperty("Sample-Service-Name", "Echo");
            return reply.get();
        });

        System.out.println("Sent: " + messageToString(reply.get()));
    }

    private String messageToString(TextMessage request) throws JMSException {
        return "{ text = %s, messageId = %s, correlationId = %s, timestamp = %s".formatted(
                request.getText(), request.getJMSMessageID(), request.getJMSCorrelationID(), request.getJMSTimestamp());
    }
}
