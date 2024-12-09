package es.ieslosmontecillos.componentes_gonzalezfrancisco;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CampoTextoNumerico extends TextField
{

    //@FXML
    //protected TextField textField;

    protected final String DECIMAL_REGEX = "[0-9]*\\.?[0-9]*";

    boolean dot = false;

    public CampoTextoNumerico()
    {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("campotextonumerico.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        }
        catch (IOException e) {
            e.printStackTrace(System.out);
        }*/
        /*textField.textProperty().addListener((observableValue, old, t1) -> {
            System.out.println(t1);
                if (!t1.matches(DECIMAL_REGEX))
                    textField.setText(old);
        });*/
    }

    @Override
    public void replaceText(int i, int i1, String s)
    {
        if (s.matches("[0-9]*"))
        {
            if (s.isEmpty() && getText(i,i1).equals("."))
            {
                dot = false;
            }

            super.replaceText(i, i1, s);
        }
        else if (s.matches("\\.") && !dot)
        {
            dot = true;
            super.replaceText(i, i1, s);
        }
    }

    @Override
    public void replaceSelection(String s)
    {
        if (s.matches(DECIMAL_REGEX))
            super.replaceSelection(s);
    }
}
