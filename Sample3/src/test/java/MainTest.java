import com.fasterxml.jackson.databind.ObjectMapper;
import model.HomeFinderSolution;
import model.Scenario;
import model.ScoredScenario;
import service.HomeFinderService;
import service.HomeFinderServiceImpl;

import java.nio.file.Files;
import java.nio.file.Paths;

public class MainTest {

    public static void main(String[] args) throws Exception {
        byte[] jsonData = null;
        if (args == null || args.length == 0) {
            jsonData = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("sample.json").toURI()));
        } else {
            jsonData = Files.readAllBytes(Paths.get(args[0]));
        }
        ObjectMapper mapper = new ObjectMapper();
        Scenario scenario = mapper.readValue(jsonData, Scenario.class);

        HomeFinderService service = new HomeFinderServiceImpl();
        ScoredScenario scoredScenario = service.precalculate(scenario);
        for (HomeFinderSolution solution: service.getAllSolutions(scenario, scoredScenario)) {
            System.out.format("The perfect house for %s is %s\n", solution.getFamily().getName(), solution.getHome().getName());
        }
    }
}