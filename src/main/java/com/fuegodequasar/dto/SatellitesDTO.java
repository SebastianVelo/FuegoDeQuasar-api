package com.fuegodequasar.dto;

import java.util.ArrayList;
import java.util.List;

import com.fuegodequasar.bean.Message;
import com.fuegodequasar.entity.Satellite;
import com.fuegodequasar.exception.PositionException;
import com.fuegodequasar.model.MSatellite;

public class SatellitesDTO {

    private List<MSatellite> msatellites;

    public SatellitesDTO() {
        this.msatellites = new ArrayList<>();
    }

    //Satellites
    public List<MSatellite> getSatellites() {
        return msatellites;
    }

    //Distances
    public double[] getDistances() {
        double[] distances = new double[this.msatellites.size()];
        for(int i = 0; i < this.msatellites.size(); i++) {
            distances[i] = this.msatellites.get(i).getDistance();
        }
        return distances;
    }

    //Messages
    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<>(); 
        this.msatellites.forEach((final MSatellite s) -> messages.add(s.getMessage()));
        return messages;
    }
    
    //Positions
    public double[][] getPositions() {
        double[][] positions = new double[this.msatellites.size()][];
        for(int i = 0; i < this.msatellites.size(); i++) {
            positions[i] = this.msatellites.get(i).getPosition().toArray();
        }
        return positions;
    }

    public void setPositions(List<Satellite> satellites) throws PositionException {
        this.msatellites.sort((MSatellite s1, MSatellite s2) -> s1.getName().compareTo(s2.getName()));
        satellites.sort((Satellite s1, Satellite s2) -> s1.getName().compareTo(s2.getName()));
        for(int i = 0; i < satellites.size(); i++) {
            Satellite satellite = satellites.get(i);
            if(msatellites.get(i).getName().equals(satellite.getName())) {
                msatellites.get(i).setPosition(satellite.getX(), satellite.getY());
            } else {
                throw new PositionException("Uno o mas de los satelites tiene un nombre incorrecto");
            }
        }
    }

}
