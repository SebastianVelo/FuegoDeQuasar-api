package com.fuegodequasar.service;

import java.util.ArrayList;
import java.util.List;

import com.fuegodequasar.bean.Position;
import com.fuegodequasar.dto.SatellitesDTO;
import com.fuegodequasar.dto.SpaceshipDTO;
import com.fuegodequasar.entity.Satellite;
import com.fuegodequasar.exception.MessageException;
import com.fuegodequasar.exception.PositionException;
import com.fuegodequasar.exception.SatelliteException;
import com.fuegodequasar.model.MSatellite;
import com.fuegodequasar.repository.SatelliteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("spaceshipService")
public class SpaceshipService {

    @Autowired
    private TrilaterationService tService;

    @Autowired
    private MessagesService mService;

    @Autowired
    private SatelliteRepository sRepository;

    public SpaceshipDTO getSpaceship(SatellitesDTO satellitesDTO) throws PositionException, MessageException, SatelliteException {
        satellitesDTO.setPositions(this.getSatellites(satellitesDTO));
        Position position = tService.getSpaceshipLocation(satellitesDTO.getPositions(), satellitesDTO.getDistances());
        String message = mService.getMessage(satellitesDTO.getMessages());
        return new SpaceshipDTO(position, message);
    }

    private List<Satellite> getSatellites(SatellitesDTO satellitesDTO) throws SatelliteException {
        List<Satellite> satellites = new ArrayList<>();
        for(MSatellite msatelite : satellitesDTO.getSatellites()) {
            Satellite satellite = sRepository.findByName(msatelite.getName());
            if(satellite == null) {
                throw new SatelliteException(msatelite.getName() + " no se encuentra en nuestros registros de satelites.");
            }
            satellites.add(satellite);
        }
        return satellites;
    }
}
