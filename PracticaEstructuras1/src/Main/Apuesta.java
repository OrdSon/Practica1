/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author ordson
 */
public class Apuesta {

    private String nombre;
    private double monto;
    private int posiciones[] = new int[10];
    private boolean rechazo = false;
    private int punteo = 0;
    public Apuesta(){
        this("zzz", "0.0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
        this.rechazo = true;
    }
    public Apuesta(String nombre, String monto, String primero, String segundo, String tercero,
            String cuarto, String quinto, String sexto, String septimo,
            String octavo, String noveno, String decimo) {
        this.nombre = nombre;
        try {
            this.monto = Double.parseDouble(monto);
            this.posiciones[0] = Integer.parseInt(primero);
            this.posiciones[1] = Integer.parseInt(segundo);
            this.posiciones[2] = Integer.parseInt(tercero);
            this.posiciones[3] = Integer.parseInt(cuarto);
            this.posiciones[4] = Integer.parseInt(quinto);
            this.posiciones[5] = Integer.parseInt(sexto);
            this.posiciones[6] = Integer.parseInt(septimo);
            this.posiciones[7] = Integer.parseInt(octavo);
            this.posiciones[8] = Integer.parseInt(noveno);
            this.posiciones[9] = Integer.parseInt(decimo);

        } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e) {
            rechazo = true;
        }
    }

    public int[] getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(int[] posiciones) {
        this.posiciones = posiciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isRechazo() {
        return rechazo;
    }

    public void setRechazo(boolean rechazo) {
        this.rechazo = rechazo;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }
    
    public void addToPunteo(int extra){
        this.punteo+=extra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Apuesta{");
        sb.append("nombre=").append(nombre);
        sb.append(", monto=").append(monto);
        sb.append(", posiciones=").append(posiciones);
        sb.append(", rechazo=").append(rechazo);
        sb.append(", punteo=").append(punteo);
        sb.append('}');
        return sb.toString();
    }


}
