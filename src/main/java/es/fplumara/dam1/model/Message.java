package es.fplumara.dam1.model;

import java.time.LocalDateTime;

public class Message {
    private String text;
    private LocalDateTime timestamp;
    private int numpalabras;

    public Message(String text) {
        this.text = text;
        this.timestamp = LocalDateTime.now();

        if (text == null || text.isBlank()){
            this.numpalabras = 0;
        }else{
            this.numpalabras = text.trim().split("//s+").length;
        }
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getNumpalabras() {
        return numpalabras;
    }
}

