module inventory {
    requires javafx.controls;
    requires javafx.fxml;

    opens inventory.controllers to javafx.fxml;
    opens inventory to javafx.fxml;
    

    exports inventory;
    exports inventory.controllers;
}
