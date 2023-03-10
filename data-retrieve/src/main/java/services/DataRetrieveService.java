package services;

import dto.CompetitorDTO;

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

    public List<CompetitorDTO> getCompetitorsFromCsv() {
        try (Stream<String> lines = Files.lines(path)) {
            List<CompetitorDTO> competitorDTOList = lines.filter(line -> !line.startsWith("#"))
                    .map(line -> getCompetitor(line))
                    .collect(Collectors.toList());
             return competitorDTOList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    private static CompetitorDTO getCompetitor(String line) {
        String[] elements = line.split(";");
        String id = elements[0];
        String name = elements[1];
        String surName = elements[2];
        int age = Integer.parseInt(elements[3]);
        String club = elements[4];
        String category = elements[5];
        CompetitorDTO competitorDTO = new CompetitorDTO(id, name, surName, age, club, category);
        return competitorDTO;
    }
    // todo possible to improve with jackson lib
    // todo https://cowtowncoder.medium.com/reading-csv-with-jackson-c4e74a15ddc1
}
