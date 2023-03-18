module com.isep.harrypotterrpg {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.isep.harrypotterrpg to javafx.fxml;
    exports com.isep.harrypotterrpg;
    exports com.isep.harrypotterrpg.sortinghat;
    opens com.isep.harrypotterrpg.sortinghat to javafx.fxml;
    exports com.isep.harrypotterrpg.core;
    opens com.isep.harrypotterrpg.core to javafx.fxml;
}