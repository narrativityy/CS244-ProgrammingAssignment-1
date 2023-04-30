module cs244.groupproject1.programmingassignment1 {
    requires javafx.controls;
    requires javafx.fxml;

    exports cs244.groupproject1;
    opens cs244.groupproject1 to javafx.fxml;
}