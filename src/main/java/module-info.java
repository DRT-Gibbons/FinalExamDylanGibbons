module com.example.finalexamjavadylangibbons {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalexamjavadylangibbons to javafx.fxml;
    exports com.example.finalexamjavadylangibbons;
}