package com.fuegodequasar.controller;

import com.fuegodequasar.dto.SatellitesDTO;
import com.fuegodequasar.dto.SpaceshipDTO;
import com.fuegodequasar.exception.MessageException;
import com.fuegodequasar.exception.PositionException;
import com.fuegodequasar.exception.SatelliteException;
import com.fuegodequasar.service.SpaceshipService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/topsecret/")
public class SpaceshipController {

    @Autowired
    @Qualifier("spaceshipService")
    private SpaceshipService service;

    @PostMapping("")
    public ResponseEntity<SpaceshipDTO> getSpaceship(@RequestBody @Validated SatellitesDTO satellites) {
        try {
            return ResponseEntity.ok().body(service.getSpaceship(satellites));
        } catch (PositionException p) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, p.getMessage(), p);
        } catch (MessageException m) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, m.getMessage(), m);
        } catch (SatelliteException s) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, s.getMessage(), s);
        }
    }
}
