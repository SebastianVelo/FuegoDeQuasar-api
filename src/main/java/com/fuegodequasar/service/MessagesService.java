package com.fuegodequasar.service;

import java.util.ArrayList;
import java.util.List;

import com.fuegodequasar.bean.Message;
import com.fuegodequasar.exception.MessageException;

import org.springframework.stereotype.Service;

@Service("messagesService")
public class MessagesService {

    public String getMessage(List<Message> messages) throws MessageException {
        if(!sameLength(messages)) {
            throw new MessageException("Los mensajes tienen cantidad distintas de palabras");
        }
        List<String> words = new ArrayList<>();
        for(int i = 0; i <  messages.get(0).getWords().size(); i++) {
            String word = null;
            for(int j = 0; j < messages.size(); j++) {
                //Si es "", continuo a la proxima iteracion
                if("".equals(messages.get(j).getWords().get(i))) {
                    continue;
                }
                if(word == null) {
                    //Si todavia no esta seteado un valor, le seteo el de la iteracion actual
                    word = messages.get(j).getWords().get(i);
                } else if(!word.equals(messages.get(j).getWords().get(i))) {
                    //Si ya tiene un valor pero no es igual al de la iteracion actual, tiro excepcion 
                    throw new MessageException("El mensaje no se puede desencriptar. Una o varias palabras son diferentes");
                } 
            }
            //Si word sigue siendo null luego de toda la iteracion por j, tiro excepcion
            if(word == null) {
                throw new MessageException("El mensaje no se puede desencriptar. Una o varias palabras estan en blanco");
            }
            words.add(word);
        }
        
        return String.join(" ", words);
    }

    private boolean sameLength(List<Message> messages) {
        int length = messages.get(0).getWords().size();
        boolean same = true;
        for (int i = 0; i < messages.size(); i++) {
            same = same && (messages.get(i).getWords().size() == length);
        }
        return same;
    }
}
