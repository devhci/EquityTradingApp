package com.sapient.equitytradingapp.et.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class is message listener class which will receive messages
 * asynchronously
 * 
 * @author dkumar40
 * 
 */
@Component
public class JMSMessageListener implements MessageListener {
	@Autowired
	SellReceiver sellReceiver;
	private static Logger logger = Logger.getLogger(ETSender.class);

	public void onMessage(Message message) {
		logger.info("Message Received Asynch");

		if (message instanceof TextMessage) {
			try {
				String msgText = ((TextMessage) message)
						.getStringProperty("BrokerMessage");
				sellReceiver.createExecution(msgText);
				System.out.println("Message received:" + msgText);
			} catch (JMSException ex) {

			} catch (JAXBException e) {
				logger.error("Jaxb Exception Thrown");
			}
		}

	}
}
