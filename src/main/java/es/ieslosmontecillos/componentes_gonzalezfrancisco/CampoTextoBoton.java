package es.ieslosmontecillos.componentes_gonzalezfrancisco;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class CampoTextoBoton extends HBox
{
    @FXML
    protected TextField textField;

    @FXML
    protected Button botonIntro;

    protected ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<>()
    {
        @Override
        protected void invalidated()
        {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return CampoTextoBoton.this;
        }

        @Override
        public String getName() {
            return "onAction";
        }
    };

    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty()
    {
        return onAction;
    }

    public final void setOnAction(EventHandler<ActionEvent> value)
    {
        onActionProperty().set(value);
    }

    public final EventHandler<ActionEvent> getOnAction()
    {
        return onActionProperty().get();
    }

    public final String getText()
    {
        return textField.getText();
    }

    public final StringProperty textProperty()
    {
        return textField.textProperty();
    }

    public final void setText(String text)
    {
        textField.setText(text);
    }

    public CampoTextoBoton()
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("campotextoboton.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        }
        catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public void botonIntroActionPerformed(ActionEvent event)
    {
        fireEvent(event);
    }
}
