module es.ieslosmontecillos.componentes_gonzalezfrancisco {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.componentes_gonzalezfrancisco to javafx.fxml;
    exports es.ieslosmontecillos.componentes_gonzalezfrancisco;
}