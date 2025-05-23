package org.example;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Database.createTable();


        ListView<Book> listView = new ListView<>();
        List<Book> savedBooks = Database.getAllBooks();


        if (savedBooks.isEmpty()) {
            Book b1 = new Book("Die Tribute von Panem", "Suzanne Collins", 2008);
            Book b2 = new Book("Cujo", "Stephen King", 1981);
            Book b3 = new Book("Der Fremde", "Albert Camus", 1942);

            Database.insertBook(b1);
            Database.insertBook(b2);
            Database.insertBook(b3);

            savedBooks = Database.getAllBooks();
        }

        listView.getItems().addAll(savedBooks);


        TextField titleField = new TextField();
        titleField.setPromptText("Titel");
        TextField authorField = new TextField();
        authorField.setPromptText("Author");
        TextField yearField = new TextField();
        yearField.setPromptText("Jahr");
        Label selectedBookLabel = new Label("Kein Buch ausgewählt");
        Button addButton = new Button("Buch hinzufügen");
        addButton.setOnAction(e ->{
            String title = titleField.getText();
            String author = authorField.getText();
            String yearText = yearField.getText();



            try {
                int year = Integer.parseInt(yearText);
                Book newBook = new Book(title, author, year);
                Database.insertBook(newBook);
                listView.getItems().add(newBook);
                System.out.println("speichern wird aufgerufen");
                titleField.clear();
                authorField.clear();
                yearField.clear();
            }
            catch (NumberFormatException ex) {
                selectedBookLabel.setText("bitte geben Sie ein gültiges Jahr ein :");
            }});


        Button showButton = new Button("Buch anzeigen");
        showButton.setOnAction(e -> {
            Book selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selectedBookLabel.setText("Titel: " + selected.getTitle() + "\n" +
                        "Author :" + selected.getAuthor() + "\n" +
                        "Jahr :" + selected.getYear());
            }else {
                selectedBookLabel.setText("Kein Buch ausgewählt.");
            }});

        VBox layout = new VBox(10, listView, showButton, selectedBookLabel,  new Label("Neues Buch Hinzufügen"),
                titleField,authorField,yearField,addButton);
        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}