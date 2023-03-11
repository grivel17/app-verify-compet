import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import repository.CompetitorJDBCRepository;
import repository.CompetitorRepository;

import java.net.URI;

public class Server {

    // base url
    public static final String BASE_URL = "http://localhost:8181/";

    //move to properties file
    private static final String dbFile = "./competitors.db";

    // run server method

    public static HttpServer startServer() {
        CompetitorRepository competitorRepository = new CompetitorJDBCRepository(dbFile);
        // todo - jedno z drugim przekazać po konstruktorze
        // todo - endpoitns lecą do konfigu ale zawieraja pole thisowane przez konstruktor
        // todo - które to pole daje dostep do interface i jego method

        EndPoints endPoints = new EndPoints();

        final ResourceConfig config = new ResourceConfig().register(endPoints);
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URL), config);
    }

    public static void main(String[] args) {
        startServer();

    }

}
