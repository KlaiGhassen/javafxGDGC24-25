package controllers;

import Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CardView {

    @FXML
    private Label age;

    @FXML
    private HBox boxh;

    @FXML
    private VBox boxv;
    @FXML
    private Label nom;

    @FXML
    private Label prenom;
    public void setPersonnes(User user) {
        nom.setText(user.getFirstName());
        prenom.setText(user.getLastName());
        age.setText(String.valueOf(user.getAge()));
        boxv.setStyle("-fx-background-color: c1e1ff");
    }


}
