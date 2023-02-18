package repository;

public class H2DataBaseSetUp {

    // todo - main db setings (later to properties)
    public final String H2_DATABASE_SETUP =
            "jdbc:h2:file:%s;AUTO_SERVER=TRUE;INIT=RUNSCRIPT FROM './db_init.sql'";

    // todo - update db schema (add id generator later)
    public final String INSERT_COMPETITOR_TO_DB = """
            MERGE INTO COMPETITORS (name, surname, yearofbirth, club, category)
            VALUES (?, ?, ?, ?, ?)
            """;

    public static final String SQL_REQUEST_GET_ALL = "SELECT * FROM COURSES";
}
