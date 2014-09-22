package com.sapient.equitytradingapp.et.jms;

import java.io.StringWriter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQDestination;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 
 * This class is a JMS Message Sender. It will send the marshalled object(got
 * form the service) on the queue.
 * 
 * @author dkumar40
 * 
 */
@Component
public class ETSender {

	private static Logger logger = Logger.getLogger(ETSender.class);
	@Autowired
	protected JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendBlockOrder(ActiveMQDestination destination,
			StringWriter stringWriter) {
		final String buffer = new String(stringWriter.toString());
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage();
				message.setStringProperty("ETMessage", buffer);
				logger.info("Message Sent Successfully");
				return message;

			}
		});

	}

}
