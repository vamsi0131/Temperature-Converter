import java.awt.*;
import java.awt.event.*;

public class TemperatureConverterAWT extends Frame {
    private TextField inputField;
    private Label resultLabel;

    public TemperatureConverterAWT() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setLayout(new FlowLayout());

        Label inputLabel = new Label("Enter temperature:");
        inputField = new TextField(10);
        Button convertButton = new Button("Convert");
        resultLabel = new Label("Result will be displayed here.");

        add(inputLabel);
        add(inputField);
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    private void convertTemperature() {
        try {
            double inputTemperature = Double.parseDouble(inputField.getText());
            double convertedTemperature = 0;

            if (getTitle().contains("Fahrenheit")) {
                convertedTemperature = (inputTemperature - 32) * 5.0 / 9.0;
                resultLabel.setText("Temperature in Celsius: " + convertedTemperature + " °C");
                setTitle("Temperature Converter (Celsius to Fahrenheit)");
            } else {
                convertedTemperature = (inputTemperature * 9.0 / 5.0) + 32;
                resultLabel.setText("Temperature in Fahrenheit: " + convertedTemperature + " °F");
                setTitle("Temperature Converter (Fahrenheit to Celsius)");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TemperatureConverterAWT app = new TemperatureConverterAWT();
            app.setVisible(true);
        });
    }
}
