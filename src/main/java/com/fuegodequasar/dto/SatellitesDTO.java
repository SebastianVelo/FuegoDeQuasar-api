package com.fuegodequasar.dto;

import java.util.ArrayList;
import java.util.List;

import com.fuegodequasar.bean.Message;
import com.fuegodequasar.entity.Satellite;
import com.fuegodequasar.model.MSatellite;

public class SatellitesDTO {

    private List<MSatellite> msatellites;

    public SatellitesDTO() {
        this.msatellites = new ArrayList<>();
    }

    /***
     * @return ArrayList de MSatellite que llegó por API
     */
    public List<MSatellite> getSatellites() {
        return msatellites;
    }

    /***
     * @return Array de las distancias de los satelites
     */
    public double[] getDistances() {
        double[] distances = new double[this.msatellites.size()];
        for (int i = 0; i < this.msatellites.size(); i++) {
            distances[i] = this.msatellites.get(i).getDistance();
        }
        return distances;
    }

    /***
     * @return Array de Message de los satelites
     */
    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<>();
        this.msatellites.forEach((final MSatellite s) -> messages.add(s.getMessage()));
        return messages;
    }

    /***
     * @return Positions de los satelites transformada en matriz de double
     */
    public double[][] getPositions() {
        double[][] positions = new double[this.msatellites.size()][];
        for (int i = 0; i < this.msatellites.size(); i++) {
            positions[i] = this.msatellites.get(i).getPosition().toArray();
        }
        return positions;
    }

    /***
     * @param satellites Lista de satelites guardados en la base de datos
     */
    public void setPositions(List<Satellite> satellites) {
        this.msatellites.sort((MSatellite s1, MSatellite s2) -> s1.getName().compareTo(s2.getName()));
        satellites.sort((Satellite s1, Satellite s2) -> s1.getName().compareTo(s2.getName()));
        for (int i = 0; i < satellites.size(); i++) {
            msatellites.get(i).setPosition(satellites.get(i).getX(), satellites.get(i).getY());
        }
    }

}
