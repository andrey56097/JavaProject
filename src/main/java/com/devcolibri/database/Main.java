package com.devcolibri.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.sql.*;
import java.util.Calendar;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO dish VALUES (?,?,?,?,?,?,?)";
    private static final String GET_ALL = "SELECT * FROM dish";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            preparedStatement = connection.prepareStatement(INSERT_NEW);
//            preparedStatement.setInt(1,2);
//            preparedStatement.setString(2,"Inserted title");
//            preparedStatement.setString(3,"Inserted desc");
//            preparedStatement.setFloat(4,0.2f);
//            preparedStatement.setBoolean(5,true);
//            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
//            preparedStatement.setBlob(7, new FileInputStream("smile.png"));
//            preparedStatement.execute();
            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

//            while (true){
//                System.out.println();
//            }

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String desc = resultSet.getString("description");
                float rating = resultSet.getFloat("rating");
                boolean published = resultSet.getBoolean("published");
                Date date = resultSet.getDate("created");
                byte[] icon = resultSet.getBytes("icon");

                System.out.println("id: " + id + ", title: " + title + ", description" + desc + ", rating: " + rating
                        + ", published: " + published + ", date " + date + ", icon: " + icon);
            }

        } catch (SQLException e) {
            System.out.println("Не удалось загрузить драйвер");
        }
//        try (Connection connection3 = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
//            statement.execute("insert into animal (animal_name, animal_desc) values ('name','desc')");
//            int res = statement.executeUpdate("UPDATE animal SET animal_name = 'New Name' WHERE id = 1;");
//            ResultSet res = statement.executeQuery("select * from animal;");
//
//            statement.addBatch("insert into animal (animal_name, animal_desc) values ('batch','desc')");
//            statement.addBatch("insert into animal (animal_name, animal_desc) values ('batch1','desc')");
//            statement.addBatch("insert into animal (animal_name, animal_desc) values ('batch2','desc')");
//
//            statement.executeBatch();
//          statement.clearBatch();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}

//    Connection connection;
//
//        try {
//                Driver driver = new FabricMySQLDriver();
//                DriverManager.registerDriver(driver);
//                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//                if (!connection.isClosed())
//                System.out.println("Соединение с БД установлено");
//                connection.close();
//                if (connection.isClosed())
//                System.out.println("Соединение с БД закрыто");
//                } catch (SQLException e) {
//                System.out.println("Не удалось загрузить драйвер");
//                }