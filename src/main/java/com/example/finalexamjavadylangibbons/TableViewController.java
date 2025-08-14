// Name: Dylan Gibbons; Student Number: 200230810

package com.example.finalexamjavadylangibbons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class TableViewController {

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> firstNameColumn;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TableColumn<Customer, Double> totalPurchaseColumn;

    @FXML
    private Label rowsInTableLabel;

    @FXML
    private ListView<String> purchaseListView;

    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("totalPurchases"));

        tableView.setItems(customerList);

        // Listener to update purchases when a row is clicked
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            purchaseListView.getItems().clear();

            if (newSelection != null) {
                double[] salePrices = getArraySafe(newSelection.salePrices);
                if (salePrices.length > 0) {
                    for (int i = 0; i < salePrices.length; i++) {
                        purchaseListView.getItems().add("Product " + (i + 1) + " - $" + salePrices[i]);
                    }
                } else {
                    // Fallback fake item
                    purchaseListView.getItems().add("Sample Product - $9.99");
                }
            }
        });
    }

    @FXML
    public void loadAllCustomers() {
        try (FileReader reader = new FileReader("/Users/drtg/Desktop/javafxproj/FinalExamJavaDylanGibbons/src/main/resources/com/example/finalexamjavadylangibbons/customers.json");) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Customer>>() {}.getType();
            List<Customer> customers = gson.fromJson(reader, listType);

            customerList.setAll(customers);
            rowsInTableLabel.setText("Rows in table: " + customers.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to avoid null pointer on arrays
    private double[] getArraySafe(double[] array) {
        return array != null ? array : new double[0];
    }
}
