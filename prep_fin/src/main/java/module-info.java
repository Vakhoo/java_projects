module com.example.demo {
    requires javafx.controls;
    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}

//module com.example.demo {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires mysql.connector.j;
//    requires java.sql;
//
//
//    opens com.example.demo to javafx.fxml;
//    exports com.example.demo;
//}