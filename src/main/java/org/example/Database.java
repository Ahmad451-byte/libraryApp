package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void createTable() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

        String sql = "CREATE TABLE IF NOT EXISTS books (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "title VARCHAR(255), " +
                "author VARCHAR(255), " +
                "year INT)";
        stmt.executeUpdate(sql);
        System.out.println("Tabelle erstellt oder bereits vorhanden.");
    } catch (SQLException e) {
        System.out.println("Fehler beim Erstellen der Tabelle:");
        e.printStackTrace();
    }
    }


    public static void insertBook(Book book) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO books(title,author,year) VALUES(?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getYear());
            int rows = stmt.executeUpdate();
            System.out.println("gespeicherte Zeilen" + rows);

        } catch (SQLException e) {
            System.out.println("Fehler beim Speichern");
            e.printStackTrace();
        }

    }

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Book b = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year")
                );
                books.add(b);
            }

        } catch (SQLException e) {
            System.out.println("Fehler beim abrufen"+e.getMessage());
            e.printStackTrace();
        }
        return books;
    }}