import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("endpoints")
public class EndPoints {

    //ta klasa musi mieć trafić do metody register, żeby serwer ją obsłużył

    // todo to do ogarnięcia https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/griz_jersey_intro/Grizzly-Jersey-Intro.html

    public EndPoints() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest() {
        return "Method get works fine";
    }

}
