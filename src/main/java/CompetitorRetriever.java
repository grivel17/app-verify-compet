import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CompetitorRetriever {
    private static Logger LOG = LoggerFactory.getLogger(CompetitorRetriever.class);
    private static final String PATH_TO_TEST_CSV = "files/sample-data.csv";
    public static final int CURRENT_YEAR_AS_INT = LocalDate.now().getYear();

    public static void main(String... args) {
        DataRetrieveService dataRetrieveService = new DataRetrieveService(Path.of(PATH_TO_TEST_CSV));
        List<Competitor> competitorList = dataRetrieveService.getCompetitorsFromCsv();
        if (!competitorList.isEmpty()) {
            competitorList.stream().forEach(c -> c.setAge(CURRENT_YEAR_AS_INT - c.getAge()));
            System.out.println(competitorList);
        }


    }
}
