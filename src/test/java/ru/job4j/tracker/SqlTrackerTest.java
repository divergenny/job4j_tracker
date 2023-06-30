package ru.job4j.tracker;

import org.junit.*;
import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SqlTrackerTest {
    private static Connection connection;

    @Ignore
    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class
                .getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(config.getProperty("url"),
                    config.getProperty("username"), config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Ignore
    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @Ignore
    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Ignore
    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Ignore
    @Test
    public void whenSaveItemAndDeleteThenMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()), nullValue());
    }

    @Ignore
    @Test
    public void whenReplaceItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item replaceItem = new Item("replace");
        replaceItem.setId(item.getId());
        tracker.replace(item.getId(), replaceItem);
        assertThat(tracker.findById(item.getId()), is(replaceItem));
    }

    @Ignore
    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item alena = tracker.add(new Item("Alena"));
        Item vladimir = tracker.add(new Item("Vladimir"));
        Item petr = tracker.add(new Item("Petr"));
        List<Item> rsl = List.of(alena, vladimir, petr);
        assertThat(tracker.findAll(), is(rsl));
    }

    @Ignore
    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item alena = new Item("Alena");
        Item vladimir = new Item("Vladimir");
        Item petr = new Item("Petr");
        tracker.add(alena);
        tracker.add(vladimir);
        tracker.add(petr);
        assertThat(tracker.findByName("Vladimir"), is(List.of(vladimir)));
    }
}
