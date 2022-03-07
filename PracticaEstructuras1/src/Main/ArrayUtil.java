/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author ordson
 */
public class ArrayUtil {

    private boolean[] checkers = new boolean[10];
    private Carrera carrera;
    private int pasos = 0;

    public boolean verificarArreglo(int[] numeros) {
        int pasos = 0;
        for (int i = 0; i < 10; i++) {
            this.pasos++;
            int actual = numeros[i] - 1;
            if (actual < 0 || actual >= 10) {
                checkers = new boolean[10];
                return false;
            }
            if (checkers[actual]) {
                System.out.println("El numero: " + numeros[i] + " esta repetido," + "En posicion " + i);
                checkers = new boolean[10];
                return false;
            }
            checkers[numeros[i] - 1] = true;
        }
        System.out.println("Ningun numero se repite");
        checkers = new boolean[10];
        return true;
    }

    /*
    Separa un texto en un array de Strings usando como punto de quiebre
    un caracter especificado
     */
    public String[] split(String texto, char caracter, int tamaño) {
        String[] datos = new String[tamaño];
        StringBuilder palabra = new StringBuilder("");
        int posicion = 0;
        for (int i = 0; i < texto.length(); i++) {
            char temp = texto.charAt(i);
            if (true) {

            }
            if (posicion >= tamaño) {

                return datos;
            }
            if (temp == caracter) {
                datos[posicion] = palabra.toString();
                palabra.setLength(0);
                posicion++;
                continue;
            }
            palabra.append(texto.charAt(i));
            if (i == texto.length() - 1) {
                datos[posicion] = palabra.toString();
                palabra.setLength(0);
            }
        }
        return datos;
    }

    public boolean[] getCheckers() {
        return checkers;
    }

    public void setCheckers(boolean[] checkers) {
        this.checkers = checkers;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }
}
