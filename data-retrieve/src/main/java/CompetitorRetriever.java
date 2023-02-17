import Helpers.Helpers;
import dto.CompetitorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.DataRetrieveService;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class CompetitorRetriever {
    private static Logger LOG = LoggerFactory.getLogger(CompetitorRetriever.class);
    public static final String PATH_TO_TEST_CSV = "files/sample-data.csv";
    private static Helpers helpers = new Helpers();


    public static void main(String... args) {
        LOG.info("Dev mode ....");
    }

    private static List<CompetitorDTO> getCompetitorDTOList(String path) {
        DataRetrieveService dataRetrieveService = new DataRetrieveService(Path.of(path));
        List<CompetitorDTO> competitorDTOList = dataRetrieveService.getCompetitorsFromCsv();
        return competitorDTOList;
    }


    // todo - dodać pustą funkcję, która zapisze  kursy do bazy

    // todo --> do helpera dodaj funkcje sprawdzającą czy nie pusty wkład

}
