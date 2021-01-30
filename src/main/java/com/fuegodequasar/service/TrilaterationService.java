package com.fuegodequasar.service;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;

import com.fuegodequasar.bean.Position;
import com.fuegodequasar.dto.SatellitesDTO;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;

@Service("trilaterationService")
public class TrilaterationService {
    
    /**
     * @param positions Las posiciones de los satelites 
     * @param distances Las distancias del spaceship con respecto a los satelites
     * @return La posicion del spaceship
     * @see SatellitesDTO#getPositions()
     * @see SatellitesDTO#getDistances()
     */
    public Position getSpaceshipLocation(double [][] positions, double[] distances) {
        TrilaterationFunction trilateration = new TrilaterationFunction(positions, distances);
        NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(trilateration, new LevenbergMarquardtOptimizer());
        return new Position(solver.solve().getPoint().toArray());
    }

}
