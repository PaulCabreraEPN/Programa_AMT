package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register {
    public JPanel MainPanel;
    private JTextField placa;
    private JTextField modelo;
    private JTextField combustible;
    private JTextField color;
    private JTextField propietario;
    private JButton registrarButton;
    private JButton cancelarButton;
    private JLabel Estado;
    private JTextField cilindraje;
    private JTextField marca;

    String url="jdbc:mysql://localhost:3306/AMT";
    String user="root";
    String passw="123456";

    vehiculos vehiculo = new vehiculos();

    public Register() {
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehiculo.setPlaca(placa.getText());
                vehiculo.setMarca(marca.getText());
                vehiculo.setModelo(modelo.getText());
                vehiculo.setClindraje(cilindraje.getText());
                vehiculo.setTipo_combustible(combustible.getText());
                vehiculo.setColor(color.getText());
                vehiculo.setPropietario(propietario.getText());

                try (Connection connection = DriverManager.getConnection(url,user,passw)) {
                    System.out.println("Connected");
                    String sql = "insert into vehiculo(Placa,Marca,Modelo,Cilindraje,Tipo_combustible,Color,Propietario) values (?,?,?,?,?,?,?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, vehiculo.getPlaca());
                    statement.setString(2, vehiculo.getMarca());
                    statement.setString(3, vehiculo.getModelo());
                    statement.setString(4, vehiculo.getClindraje());
                    statement.setString(5, vehiculo.getTipo_combustible());
                    statement.setString(6, vehiculo.getColor());
                    statement.setString(7, vehiculo.getPropietario());

                    statement.executeUpdate();
                    Estado.setText("Registro Exitoso");

                }catch (SQLException e1){
                    System.out.println(e1.getMessage());
                    Estado.setText("Algo Salió mal :(");
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placa.setText(null);
                marca.setText(null);
                modelo.setText(null);
                cilindraje.setText(null);
                combustible.setText(null);
                color.setText(null);
                propietario.setText(null);
            }
        });
    }
}
