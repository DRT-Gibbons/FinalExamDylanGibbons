module com.example.finalexamjavadylangibbons {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.finalexamjavadylangibbons to javafx.fxml;
    exports com.example.finalexamjavadylangibbons;
}