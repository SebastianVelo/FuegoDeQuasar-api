package com.fuegodequasar.service;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;

import com.fuegodequasar.bean.Position;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;

@Service("trilaterationService")
public class TrilaterationService {
    
    public Position getSpaceshipLocation(double [][] positions, double[] distances) {
        TrilaterationFunction trilateration = new TrilaterationFunction(positions, distances);
        NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(trilateration, new LevenbergMarquardtOptimizer());
        return new Position(solver.solve().getPoint().toArray());
    }

}
