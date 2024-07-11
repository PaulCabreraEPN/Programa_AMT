package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Search {
    public JPanel MainPanel;
    private JTextField campo;
    private JButton buscarButton;
    private JButton regresarButton;
    private JLabel placa;
    private JLabel marca;
    private JLabel modelo;
    private JLabel cilindraje;
    private JLabel combustible;
    private JLabel color;
    private JLabel propietario;
    private JLabel Observaciones;


    String url="jdbc:mysql://localhost:3306/AMT";
    String user="root";
    String passw="123456";

    public Search() {
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Selector().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500,350);
                frame.setVisible(true);

                ((JFrame)SwingUtilities.getWindowAncestor(regresarButton)).dispose();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (Connection connection= DriverManager.getConnection(url,user,passw)){
                    String query = "select * from vehiculo where Placa='"+campo.getText()+"'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()){
                        placa.setText("- Placa: "+resultSet.getString("Placa"));
                        marca.setText("- Marca: "+resultSet.getString("Marca"));
                        modelo.setText("- Modelo: "+resultSet.getString("Modelo"));
                        cilindraje.setText("- Cilindraje: "+resultSet.getString("Cilindraje"));
                        combustible.setText("- Tipo de combustible: "+resultSet.getString("Tipo_combustible"));
                        color.setText("- Color: "+resultSet.getString("Color"));
                        propietario.setText("- Propietario: "+resultSet.getString("Propietario"));

                        Observaciones.setText("Vehiculo Encontrado");
                    }


                    if (propietario.getText()=="-"){
                        Observaciones.setText("Vehiculo NO Registrado");
                    }

                }catch (SQLException e1){
                    System.out.println(e1.getMessage());
                }

            }
        });
    }
}
