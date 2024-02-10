package com.projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverterGUI {

    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> conversions;
    private JLabel inputLabel;
    private JTextField inputField;
    private JButton convertButton;
    private JLabel outputLabel;

    public TemperatureConverterGUI(){

        frame = new JFrame("Temperature Converter");
        panel = new JPanel();
        conversions = new JComboBox<>(new String[]{"Celsius to Fahrenheit","Fahrenheit to Celsius","Celsius to Kelvin","Kelvin to Celsius","Kelvin to Fahrenheit","Fahrenheit to Kelvin"});
        inputLabel = new JLabel("Enter Temperature");
        inputField = new JTextField(10);
        convertButton = new JButton("convert");
        outputLabel = new JLabel();

        //function for convert Button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        panel.add(conversions);
        panel.add(inputField);
        panel.add(inputLabel);
        panel.add(convertButton);
        panel.add(outputLabel);

        panel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 250);
        frame.setVisible(true);


    }


    private void convertTemperature(){

        try{
            double temperature = Double.parseDouble(inputField.getText());
            String option = (String) conversions.getSelectedItem();
            String Result = "";

            switch(option){
                case "Celsius to Fahrenheit":
                    Result = String.format("%.2f celsius = %.2f fahrenheit" , temperature,celsiusToFahrenheit(temperature));
                    break;
                case "Fahrenheit to Celsius":
                    Result = String.format("%.2f fahrenheit = %.2f celsius" , temperature,fahrenheitToCelsius(temperature));
                    break;
                case "Celsius to Kelvin":
                    Result = String.format("%.2f celsius = %.2f Kelvin" , temperature,celsiusToKelvin(temperature));
                    break;
                case "Kelvin to Celsius":
                    Result = String.format("%.2f Kelvin = %.2f celsius" , temperature,kelvinToCelsius(temperature));
                    break;
                case "Kelvin to Fahrenheit":
                    Result = String.format("%.2f Kelvin = %.2f Fahrenheit" , temperature,KelvinToFahrenheit(temperature));
                    break;
                case "Fahrenheit to Kelvin":
                    Result = String.format("%.2f Fahrenheit = %.2f Kelvin" , temperature,fahrenheitToKelvin(temperature));
                    break;
                default:
                    Result = "INVALID!";
            }
            outputLabel.setText(Result);

        }catch (NumberFormatException ex){
            outputLabel.setText("Invalid input");
        }
    }


    //methods for temperature conversion
    private double celsiusToFahrenheit(double celsius){
        return (9/5.0 * celsius) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32 ) * 5/9;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double KelvinToFahrenheit(double kelvin) {
        return 1.8 * (kelvin - 273.15) + 32;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    //main function
    public static void main(String [] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverterGUI();
            }
        });
    }
}



//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class TemperatureConverterGUI {
//
//    private JFrame frame;
//    private JPanel panel;
//    private JComboBox<String> conversions;
//    private JLabel inputLabel;
//    private JTextField inputField;
//    private JButton convertButton;
//    private JTextArea outputTextArea;
//    private JScrollPane outputScrollPane;
//
//    public TemperatureConverterGUI(){
//
//        frame = new JFrame("Temperature Converter");
//        panel = new JPanel();
//        conversions = new JComboBox<>(new String[]{"Celsius to Fahrenheit","Fahrenheit to Celsius","Celsius to Kelvin","Kelvin to Celsius","Kelvin to Fahrenheit","Fahrenheit to Kelvin"});
//        inputLabel = new JLabel("Enter Temperature");
//        inputField = new JTextField(5);
//        convertButton = new JButton("convert");
//        outputTextArea = new JTextArea(1, 17);
//        outputScrollPane = new JScrollPane(outputTextArea);
//
//        //function for convert Button
//        convertButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                convertTemperature();
//            }
//        });
//
//        panel.add(conversions);
//        panel.add(inputField);
//        panel.add(inputLabel);
//        panel.add(convertButton);
//        panel.add(outputScrollPane);
//
//        panel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
//
//        frame.add(panel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 250);
//        frame.setVisible(true);
//    }
//
//
//    private void convertTemperature(){
//
//        try{
//            double temperature = Double.parseDouble(inputField.getText());
//            String option = (String) conversions.getSelectedItem();
//            String Result = "";
//
//            switch(option){
//                case "Celsius to Fahrenheit":
//                    Result = String.format("%.2f celsius = %.2f fahrenheit" , temperature,celsiusToFahrenheit(temperature));
//                    break;
//                case "Fahrenheit to Celsius":
//                    Result = String.format("%.2f fahrenheit = %.2f celsius" , temperature,fahrenheitToCelsius(temperature));
//                    break;
//                case "Celsius to Kelvin":
//                    Result = String.format("%.2f celsius = %.2f Kelvin" , temperature,celsiusToKelvin(temperature));
//                    break;
//                case "Kelvin to Celsius":
//                    Result = String.format("%.2f Kelvin = %.2f celsius" , temperature,kelvinToCelsius(temperature));
//                    break;
//                case "Kelvin to Fahrenheit":
//                    Result = String.format("%.2f Kelvin = %.2f Fahrenheit" , temperature,KelvinToFahrenheit(temperature));
//                    break;
//                case "Fahrenheit to Kelvin":
//                    Result = String.format("%.2f Fahrenheit = %.2f Kelvin" , temperature,fahrenheitToKelvin(temperature));
//                    break;
//                default:
//                    Result = "INVALID!";
//            }
//            outputTextArea.setText(Result); // Changed to setText() method
//
//        }catch (NumberFormatException ex){
//            outputTextArea.setText("Invalid input"); // Changed to setText() method
//        }
//    }
//
//    // methods for temperature conversion
//    private double celsiusToFahrenheit(double celsius){
//        return (9/5.0 * celsius) + 32;
//    }
//
//    public static double fahrenheitToCelsius(double fahrenheit) {
//        return (fahrenheit - 32 ) * 5/9;
//    }
//
//    public static double celsiusToKelvin(double celsius) {
//        return celsius + 273.15;
//    }
//
//    public static double kelvinToCelsius(double kelvin) {
//        return kelvin - 273.15;
//    }
//
//    public static double KelvinToFahrenheit(double kelvin) {
//        return 1.8 * (kelvin - 273.15) + 32;
//    }
//
//    public static double fahrenheitToKelvin(double fahrenheit) {
//        return (fahrenheit - 32) * 5/9 + 273.15;
//    }
//
//    //main function
//    public static void main(String [] args){
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new TemperatureConverterGUI();
//            }
//        });
//    }
//
//}