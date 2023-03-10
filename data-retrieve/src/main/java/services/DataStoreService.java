package services;

import domain.Competitor;
import dto.CompetitorDTO;
import repository.CompetitorRepository;

import java.util.List;

public class DataStoreService {
    private final CompetitorRepository competitorRepository;

    public DataStoreService(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    public void collectAllCompetitors(List<CompetitorDTO> competitorDTOList){
        competitorDTOList.stream()
                .forEach(competitorDTO -> competitorRepository.save(getCompetitor(competitorDTO)));
    }

    private static Competitor getCompetitor(CompetitorDTO competitorDTO) {
        return new Competitor(
                competitorDTO.getId(),
                competitorDTO.getName(),
                competitorDTO.getSurName(),
                competitorDTO.getAge(),
                competitorDTO.getClub(),
                competitorDTO.getCategory()
        );
    }
}
