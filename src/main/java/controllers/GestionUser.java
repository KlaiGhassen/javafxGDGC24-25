package controllers;

import Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import services.UserService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class GestionUser {
    UserService userService = new UserService();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField age_tf;

    @FXML
    private HBox boxh;

    @FXML
    private TextField nom_tf;

    @FXML
    private TextField prenom_tf;

    @FXML
    void addPersonne(ActionEvent event) {
        User user = new User(nom_tf.getText(), prenom_tf.getText(), Integer.parseInt(age_tf.getText()));
        try {
            userService.insert(user);
            nom_tf.setText("");
            prenom_tf.setText("");
            age_tf.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("User Added successfully");
            alert.showAndWait();
            addUserCard(user);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            System.out.println(e.getMessage());

        }

    }

    @FXML
    void showPerosnnoe(ActionEvent event) {

    }

    @FXML
    void initialize() {
        List<User> users;
        try {
            users = userService.find();
            for (User user : users) {
                addUserCard(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    void addUserCard(User user) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/cardview.fxml"));
        HBox card;
        try {
            card = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CardView c = fxmlLoader.getController();
        c.setPersonnes(user);
        boxh.getChildren().add(card);
    }
}
