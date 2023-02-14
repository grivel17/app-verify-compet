import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Demo {
    private static Logger LOG = LoggerFactory.getLogger(Demo.class);

    //make a csv file


    public static void main(String... args) {
        LOG.info("Let's start...");
        Path path = Path.of("files/sample-data.xls");
        boolean ifPathExist = Files.exists(path);
        LOG.info("If file exist {}", ifPathExist);

    }
}
