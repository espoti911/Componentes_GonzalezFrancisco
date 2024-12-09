package es.ieslosmontecillos.componentes_gonzalezfrancisco;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.io.IOException;

public class Temporizador extends HBox
{
    public IntegerProperty timer = new SimpleIntegerProperty(0);
    public StringProperty labelString = new SimpleStringProperty("Temporizador: ");
    protected Timeline timeline;

    @javafx.fxml.FXML
    private Label unitLabel;
    @javafx.fxml.FXML
    private Label timerTextLabel;
    @javafx.fxml.FXML
    private HBox root;
    @javafx.fxml.FXML
    private Label timerValueLabel;

    public Temporizador()
    {
        super();
        /*timer.addListener((observable, oldValue, newValue) -> {
            setText(String.valueOf(newValue));
        });*/
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();
        }
        catch (IOException exception)
        {
            throw new RuntimeException(exception);
        }

        timerValueLabel.textProperty().bind(timer.asString());
        timerTextLabel.textProperty().bind(labelString);
    }

    public StringProperty labelStringProperty()
    {
        return labelString;
    }

    public void setLabelString(String text)
    {
        labelString.set(text);
    }

    public String getLabelString()
    {
        return labelString.get();
    }

    public void setTimer(int newTimer)
    {
        if (newTimer <= 0)
            return;

        stopTimer();
        timer.set(newTimer);
    }

    public int getTimer()
    {
        return timer.get();
    }

    public IntegerProperty timerProperty()
    {
        return timer;
    }

    public void startTimer()
    {
        if (timer.get() <= 0)
            return;

        if (timeline != null && timeline.getStatus() == Animation.Status.RUNNING)
            return;

        timeline = new Timeline(new KeyFrame(Duration.seconds(timer.get()), new KeyValue(timer, 0)));
        timeline.setOnFinished(this::onFinishTime);

        //setText(String.valueOf(timerProperty().get()));
        timeline.play();
    }

    public void stopTimer()
    {
        if (timeline != null)
            timeline.pause();
    }

    protected void onFinishTime(ActionEvent event)
    {
        stopTimer();
        fireEvent(event);
    }

    protected ObjectProperty<EventHandler<ActionEvent>> onAction = new ObjectPropertyBase<>()
    {
        @Override
        protected void invalidated()
        {
            setEventHandler(ActionEvent.ACTION, get());
        }

        @Override
        public Object getBean() {
            return Temporizador.this;
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
}
