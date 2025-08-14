//Name: Dylan Gibbons; Student Number: 200230810

package com.example.finalexamjavadylangibbons;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }



    // Fetch from api
    @FXML
    public void onFetchDataClick() {
        try {
            Customer[] customers = APIService.fetchCustomers().toArray(new Customer[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}