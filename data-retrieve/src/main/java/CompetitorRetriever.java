import Helpers.Helpers;
import dto.CompetitorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.CompetitorJDBCRepository;
import repository.CompetitorRepository;
import services.DataRetrieveService;
import services.DataStoreService;

import java.nio.file.Path;
import java.util.List;

public class CompetitorRetriever {
    private static Logger LOG = LoggerFactory.getLogger(CompetitorRetriever.class);
    private static final String PATH_TO_TEST_CSV = "files/sample-data.csv";
    private static Helpers helpers = new Helpers();
    private static CompetitorRepository competitorRepository = new CompetitorJDBCRepository("./competitors.db");

    public static void main(String... args) {
        saveCompetitors(PATH_TO_TEST_CSV);
    }

    private static List<CompetitorDTO> getCompetitorList(String path) {
        DataRetrieveService dataRetrieveService = new DataRetrieveService(Path.of(path));
        List<CompetitorDTO> competitorList = dataRetrieveService.getCompetitorsFromCsv();
        return competitorList;
    }

    private static void saveCompetitors(String path){
        CompetitorRepository competitorRepository = new CompetitorJDBCRepository("./competitors.db");
        DataStoreService dataStoreService = new DataStoreService(competitorRepository);
        dataStoreService.collectAllCompetitors(getCompetitorList(path));
    }
}
