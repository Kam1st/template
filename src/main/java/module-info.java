module com.hatteea.template {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.hatteea.template to javafx.fxml;
    exports com.hatteea.template;
}