package fr.karma;

import fr.karma.config.AppConfig;
import fr.karma.entities.Message;
import fr.karma.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.json.JSONException;
import org.json.JSONObject;
import java.time.Duration;
import java.util.Collections;

@Slf4j
public class Consumer {

    public static void main(String[] args){
        final KafkaConsumer<byte[], String> consumer = new KafkaConsumer<>(AppConfig.getConsumerConfig());
        consumer.subscribe(Collections.singleton(AppConfig.getTopicName()));
        User creator = new User("Creator");
        User sombody = new User("Somebody");

        while(true){
            ConsumerRecords<byte[],String> records = consumer.poll(Duration.ofSeconds(Integer.MAX_VALUE));

            for(ConsumerRecord record : records){
                log.info("récupération contenue : {}, partition : {}, offset : {}",record.value(),record.partition(),
                        record.offset());
                try {
                    String str = record.value().toString();
                    JSONObject jsonObject = new JSONObject(str);
                    System.out.println("From ===> " +jsonObject.get("from").toString());
                    System.out.println("To ===> " +jsonObject.get("to").toString());
                    System.out.println("Object ===> " +jsonObject.get("object").toString());
                    System.out.println("Message ===> " +jsonObject.get("body").toString());
                    System.out.println("------------------------------------------------------------------------------");

                } catch (JSONException err) {
                    System.out.println("Exception : "+err.toString());
                }
                log.info(creator.toString());
            }
        }
    }

}
