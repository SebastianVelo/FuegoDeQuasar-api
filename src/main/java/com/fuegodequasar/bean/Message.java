package com.fuegodequasar.bean;

import java.util.List;

public class Message {
    
    private List<String> words;

    public Message() {

    }
    
    public Message(List<String> words) {
        this.words = words;
    }
    
    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
    
}
