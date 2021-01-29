package com.fuegodequasar.service;

import com.fuegodequasar.bean.Position;
import com.fuegodequasar.dto.SatellitesDTO;
import com.fuegodequasar.dto.SpaceshipDTO;
import com.fuegodequasar.exception.MessageException;
import com.fuegodequasar.exception.PositionException;
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

    public SpaceshipDTO getSpaceship(SatellitesDTO satellitesDTO) throws PositionException, MessageException {
        satellitesDTO.setPositions(sRepository.findAll());
        Position position = tService.getSpaceshipLocation(satellitesDTO.getPositions(), satellitesDTO.getDistances());
        String message = mService.getMessage(satellitesDTO.getMessages());
        return new SpaceshipDTO(position, message);
    }
}
