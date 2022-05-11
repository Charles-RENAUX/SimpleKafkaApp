package fr.karma.entities;

import java.util.List;
import java.util.UUID;

public class User {
    UUID id;
    String username;
    List<Message> listMessage;

    public User(String username) {
        this.id = UUID.randomUUID();
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<Message> getListMessage() {
        return listMessage;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addNewMessage(Message message) {
        this.listMessage.add(message);
    }

}
