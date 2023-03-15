module com.isep.harrypotterrpg {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.isep.harrypotterrpg to javafx.fxml;
    exports com.isep.harrypotterrpg;
}