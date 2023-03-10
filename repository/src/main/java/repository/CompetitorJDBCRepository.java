package repository;

import domain.Competitor;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompetitorJDBCRepository implements CompetitorRepository {

    public final String H2_DATABASE_SETUP =
            "jdbc:h2:file:%s;AUTO_SERVER=TRUE;INIT=RUNSCRIPT FROM './db_init.sql'";

    public final String INSERT_COMPETITOR_TO_DB = """
            MERGE INTO COMPETITORS (id, name, surname, yearofbirth, club, category)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    public static final String SQL_REQUEST_GET_ALL = "SELECT * FROM COMPETITORS";

    private final DataSource dataSource;


    public CompetitorJDBCRepository(String dbFile) {
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL(H2_DATABASE_SETUP.formatted(dbFile));
        this.dataSource = jdbcDataSource;
    }

    @Override
    public void save(Competitor competitor) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPETITOR_TO_DB);
            preparedStatement.setString(1, competitor.id());
            preparedStatement.setString(2, competitor.name());
            preparedStatement.setString(3, competitor.surname());
            preparedStatement.setLong(4, competitor.yearofbirth());
            preparedStatement.setString(5, competitor.club());
            preparedStatement.setString(6, competitor.category());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Competitor> getAllCompetitors() {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_REQUEST_GET_ALL);
            List<Competitor> competitors = new ArrayList<>();
            while (resultSet.next()) {
                Competitor competitor = new Competitor(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getLong(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
                competitors.add(competitor);
            }
            return Collections.unmodifiableList(competitors);
        } catch (SQLException e) {
           throw new RuntimeException();
        }

    }
}

