import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataRetrieveService {
    private Path path;

    public DataRetrieveService(Path path) {
        this.path = Path.of(String.valueOf(path));
    }

    public List<Competitor> getCompetitorsFromCsv() {
        try (Stream<String> lines = Files.lines(path)) {
            List<Competitor> competitorList = lines.filter(line -> !line.startsWith("#"))
                    .map(line -> getCompetitor(line))
                    .collect(Collectors.toList());
             return competitorList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    private static Competitor getCompetitor(String line) {
        String[] elements = line.split(";");
        String name = elements[0];
        String surName = elements[1];
        int age = Integer.parseInt(elements[2]);
        String club = elements[3];
        String category = elements[4];
        Competitor competitor = new Competitor(name, surName, age, club, category);
        return competitor;
    }
}
