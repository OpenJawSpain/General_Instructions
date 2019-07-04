package service;

import model.HomeFinderSolution;
import model.Scenario;
import model.ScoredScenario;

import java.util.List;

public interface HomeFinderService {

    ScoredScenario precalculate(Scenario scenario);

    List<HomeFinderSolution> getAllSolutions(Scenario scenario, ScoredScenario scoredScenario);

}
