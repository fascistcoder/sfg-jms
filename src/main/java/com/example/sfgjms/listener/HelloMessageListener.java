package com.example.sfgjms.listener;

import com.example.sfgjms.config.JmsConfig;
import com.example.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 21/03/22
 */
@RequiredArgsConstructor
@Component
public class HelloMessageListener {

	private final JmsTemplate jmsTemplate;

	@JmsListener(destination = JmsConfig.MY_QUEUE)
	public void listen(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders headers, Message message) {
		//		System.out.println("I got a message !!!");
		//		System.out.println(helloWorldMessage);
	}

	@JmsListener(destination = JmsConfig.MY_SEND_RECEIVE_QUEUE)
	public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
			@Headers MessageHeaders headers, Message jmsMessage, org.springframework.messaging.Message message) throws JMSException {

		HelloWorldMessage payloadMsg = HelloWorldMessage
				.builder()
				.id(UUID.randomUUID())
				.message("World!!")
				.build();

		//jmsTemplate.convertAndSend((Destination) message.getHeaders(), payloadMsg);
		jmsTemplate.convertAndSend(jmsMessage.getJMSReplyTo(), payloadMsg);
	}

}
