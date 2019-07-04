package service;

import helper.Calculator;
import model.Family;
import model.Home;
import model.HomeFinderSolution;
import model.Scenario;
import model.Score;
import model.ScoredScenario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFinderServiceImpl implements HomeFinderService {

    public ScoredScenario precalculate(Scenario scenario) {
        Map<Home, Score> scoreMap = new HashMap<>();
        for (Home home : scenario.getHomes()) {
            scoreMap.put(home, Score.builder()
                    .modifierPerDog(Calculator.getBestScore(home, scenario.getKeyLocations().getDogParks()))
                    .modifierPerChildren(Calculator.getBestScore(home, scenario.getKeyLocations().getPools()))
                    .modifierPerWorker(Calculator.getBestScore(home, scenario.getKeyLocations().getWorkplaces()))
                    .build());
        }
        return ScoredScenario.builder().scoreMap(scoreMap).build();
    }

    public List<HomeFinderSolution> getAllSolutions(Scenario scenario, ScoredScenario scoredScenario) {
        List<HomeFinderSolution> solutionList = new ArrayList<>();
        for (Family family : scenario.getFamilies()) {
            HomeFinderSolution solution = HomeFinderSolution.builder().family(family).score(Integer.MIN_VALUE).build();
            scoredScenario.getScoreMap().keySet().stream().filter(home -> home.getPrice() <= family.getBudget()).forEach(validHome -> {
                Score score = scoredScenario.getScoreMap().get(validHome);
                int homeScore = 100 + family.getDogs() * score.getModifierPerDog() + family.getChildren() * score.getModifierPerChildren() + family.getWorkers() * score.getModifierPerWorker();
                if (homeScore > solution.getScore()) {
                    solution.setScore(homeScore);
                    solution.setHome(validHome);
                }
            });
            solutionList.add(solution);
        }
        return solutionList;
    }

}
