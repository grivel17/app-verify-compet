import domain.Competitor;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import repository.CompetitorRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Path("/")
public class EndPoints {

    CompetitorRepository competitorRepository;

    public EndPoints(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    // todo to do ogarnięcia https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/griz_jersey_intro/Grizzly-Jersey-Intro.html

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest() {
        return "Method get works fine";
    }

    @GET
    @Path("comp")
    @Produces(MediaType.APPLICATION_JSON)
    public Stream<Competitor> getAllCompetitors() {
        return competitorRepository
                .getAllCompetitors()
                .stream()
                .sorted(Comparator.comparing(Competitor::yearofbirth));
    }

//    @GET
//    @Path("comp")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Competitor> getAllCompetitors() {
//        return competitorRepository.getAllCompetitors();
//
//    }

}
