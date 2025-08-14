//Name: Dylan Gibbons; Student Number: 200230810

package com.example.finalexamjavadylangibbons;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind columns to customer properties
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("totalPurchases"));

        tableView.setItems(customerList);
    }

    @FXML
    public void loadAllCustomers() {
        try (FileReader reader = new FileReader("customers.json")) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Customer>>() {}.getType();
            List<Customer> customers = gson.fromJson(reader, listType);

            customerList.setAll(customers);
            rowsInTableLabel.setText("Rows in table: " + customers.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
