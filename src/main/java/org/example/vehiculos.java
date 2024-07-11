package org.example;

public class vehiculos {
    private String Placa;
    private String Marca;
    private String Modelo;
    private String Clindraje;
    private String Tipo_combustible;
    private String Color;
    private String Propietario;

    /*Consructores*/
    public vehiculos() {
    }

    public vehiculos(String placa, String marca, String modelo, String clindraje, String tipo_combustible, String color, String propietario) {
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        Clindraje = clindraje;
        Tipo_combustible = tipo_combustible;
        Color = color;
        Propietario = propietario;
    }

    /*getters & setters*/
    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getClindraje() {
        return Clindraje;
    }

    public void setClindraje(String clindraje) {
        Clindraje = clindraje;
    }

    public String getTipo_combustible() {
        return Tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        Tipo_combustible = tipo_combustible;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String propietario) {
        Propietario = propietario;
    }

    /*Metodos*/
    public void mostrar_vehiculo(){

        System.out.println(">>>>>  Vehiculo Registrados  <<<<<");
        System.out.println("Placa: " + this.getPlaca());
        System.out.println("Marca: " + this.getMarca());
        System.out.println("Modelo: " + this.getModelo());
        System.out.println("Clindraje: " + this.getClindraje());
        System.out.println("Tipo combustible: " + this.getTipo_combustible());
        System.out.println("Color: " + this.getColor());
        System.out.println("Propietario: " + this.getPropietario());
    }
}
