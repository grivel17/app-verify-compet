package Helpers;

import dto.CompetitorDTO;

import java.time.LocalDate;
import java.util.List;

public class Helpers {

    private static final int CURRENT_YEAR_AS_INT = LocalDate.now().getYear();

    public Helpers() {
    }

    public void ageToYearOfBirth(List<CompetitorDTO> competitorDTOList) {
        competitorDTOList.stream().forEach(c -> c.setAge(CURRENT_YEAR_AS_INT - c.getAge()));
    }
}
