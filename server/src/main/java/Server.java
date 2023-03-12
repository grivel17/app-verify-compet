import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.CompetitorJDBCRepository;
import repository.CompetitorRepository;

import java.net.URI;

public class Server {

    private static Logger LOGGER = LoggerFactory.getLogger(Server.class);

    // base url
    public static final String BASE_URL = "http://localhost:8181/";

    //move to properties file
    private static final String dbFile = "./competitors.db";

    // run server method

    public static HttpServer startServer() {
        final EndPoints endPoints = new EndPoints(new CompetitorJDBCRepository(dbFile));
        final ResourceConfig config = new ResourceConfig().register(endPoints);
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URL), config);
    }

    public static void main(String[] args) {
        startServer();
        LOGGER.info("Server has started and listening on {}", BASE_URL);

    }

}
