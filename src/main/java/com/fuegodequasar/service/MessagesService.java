package com.fuegodequasar.service;

import java.util.ArrayList;
import java.util.List;

import com.fuegodequasar.bean.Message;
import com.fuegodequasar.dto.SatellitesDTO;
import com.fuegodequasar.exception.MessageException;

import org.springframework.stereotype.Service;

@Service("messagesService")
public class MessagesService {

    /**
     * @param messages Una lista de Message enviado por API
     * @return El mensaje desencriptado al spaceship, si se pudiera
     * @throws MessageException Si no se puede desencriptar el mensaje
     * @see SatellitesDTO#getMessages()
     */
    public String getMessage(List<Message> messages) throws MessageException {
        if(!sameLength(messages))
            throw new MessageException("Los mensajes tienen cantidad distintas de palabras");
            
        List<String> words = new ArrayList<>();
        for(int i = 0; i <  messages.get(0).getWords().size(); i++) {
            String word = null;
            for(int j = 0; j < messages.size(); j++) {
                if("".equals(messages.get(j).getWords().get(i))) //Si es "", continuo a la proxima iteracion
                    continue;
                
                if(word == null) { //Si todavia no esta seteado un valor, le seteo el de la iteracion actual
                    word = messages.get(j).getWords().get(i);
                } else if(!word.equals(messages.get(j).getWords().get(i))) { //Si ya tiene un valor pero no es igual al de la iteracion actual, tiro excepcion 
                    throw new MessageException("El mensaje no se puede desencriptar. Una o varias palabras son diferentes");
                } 
            }
            if(word == null) //Si word sigue siendo null luego de toda la iteracion por j, tiro excepcion
                throw new MessageException("El mensaje no se puede desencriptar. Una o varias palabras estan en blanco");
            words.add(word);
        }
        return String.join(" ", words);
    }

    /***
     * 
     * @param messages Una lista de Message enviado por API
     * @return Si todos los mensajes tienen la misma cantidad de palabras
     */
    private boolean sameLength(List<Message> messages) {
        int length = messages.get(0).getWords().size();
        for (int i = 0; i < messages.size(); i++) {
            if(length != messages.get(i).getWords().size())
                return false;
        }
        return true;
    }
}
