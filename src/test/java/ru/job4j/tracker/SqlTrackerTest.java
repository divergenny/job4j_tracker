package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
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

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class
                .getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemAndDeleteThenMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()), nullValue());
    }

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

    @Test
    public void whenFindAll() {
        List<Item> rsl = List.of(new Item("Alena"), new Item("Vladimir"), new Item("Petr"));
        int rslItr = 0;
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(new Item("Alena"));
        tracker.add(new Item("Vladimir"));
        tracker.add(new Item("Petr"));
        for (Item item : tracker.findAll()) {
            assertThat(item.getName(), is(rsl.get(rslItr).getName()));
            rslItr++;
        }
    }

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
