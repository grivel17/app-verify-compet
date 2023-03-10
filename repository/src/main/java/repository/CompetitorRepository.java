package repository;

import domain.Competitor;

import java.util.List;

public interface CompetitorRepository {
    void save(Competitor competitor);

    List<Competitor> getAllCompetitors();

}
