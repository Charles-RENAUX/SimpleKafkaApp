package fr.karma.entities;


public class Message {
    String object;
    String body;
    String from;
    String to;


    public Message(String body, String from, String to) {
        this.body = body;
        this.from = from;
        this.to = to;
    }

    public Message(String object, String body, String from, String to) {
        this.object = object;
        this.body = body;
        this.from = from;
        this.to = to;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getBody() {
        return body;
    }



    public void setBody(String body) {
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public boolean hasAnObject(){
        if (this.object == null)
        {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "'object':'" + object + '\'' +
                ", 'body':'" + body + '\'' +
                ", 'from':'" + from + '\'' +
                ", 'to':'" + to + '\'' +
                '}';
    }

}
