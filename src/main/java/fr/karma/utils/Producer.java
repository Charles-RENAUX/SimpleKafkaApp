package fr.karma.utils;

import fr.karma.config.AppConfig;
import fr.karma.entities.Message;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Producer {

    public void putInTopic(Message message){
        KafkaProducer<byte[],String> producer = new KafkaProducer<>(AppConfig.getProducerConfig());
        Runtime.getRuntime().addShutdownHook(new Thread(producer::close));
        ProducerRecord<byte[],String> messageToTopic = new ProducerRecord<>(AppConfig.getTopicName(), message.toString());
        producer.send(messageToTopic);
        log.info("From : "+message.getFrom()
                +"|| To : "+message.getTo()
                +"|| Object : "+message.getObject()
                +"|| Message : "+message.getBody()
                +"|| Sur le topic ==>"+AppConfig.getTopicName()
                +"|| Producer ==>"+messageToTopic
        );

    }

}
