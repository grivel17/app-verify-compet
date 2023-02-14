import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataRetrieveService {
    private static Logger LOG = LoggerFactory.getLogger(DataRetrieveService.class);

    private static Path path = Path.of("files/sample-data.csv");

    public static void main(String... args) {
        try(Stream<String> lines = Files.lines(path)) {
            List<Competitor> competitorsList = lines
                    .filter(line -> !line.startsWith("#"))
                    .map(line -> getCompetitor(line))
                    .collect(Collectors.toList());
            System.out.println(competitorsList);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
