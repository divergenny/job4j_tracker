package ru.job4j.tracker;

import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {
    private Connection cn;
    private Boolean resultOfQuery = false;

    @Override
    public void init() {
        try (InputStream in = SqlTracker.class
                .getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     cn.prepareStatement("insert into items(name, created)"
                             + " values(?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getTime()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        resultOfQuery = false;
        try (PreparedStatement statement = cn.prepareStatement("update items "
                + "set name = ?, "
                + "created = ? "
                + "where id = ?"
        )) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getTime()));
            statement.setInt(3, id);
            statement.execute();
            resultOfQuery = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultOfQuery;
    }

    @Override
    public boolean delete(int id) {
        resultOfQuery = false;
        try (PreparedStatement statement = cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
            resultOfQuery = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultOfQuery;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where name like ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    item = new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }
}
