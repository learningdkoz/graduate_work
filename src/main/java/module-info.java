module com.example.graduate_work {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.graduate_work to javafx.fxml;
    exports com.example.graduate_work;
}