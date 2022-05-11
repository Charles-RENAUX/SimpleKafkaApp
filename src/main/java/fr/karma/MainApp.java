package fr.karma;

import fr.karma.entities.Message;
import fr.karma.utils.Producer;


public class MainApp {

    public static void main(String[] args) {
        Message sentMessage = new Message("Test2","Je suis quand même balèze","Creator","Somebody");
        Producer producer = new Producer();

        producer.putInTopic(sentMessage);


    }
}
