/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Lists.Lista;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ordson
 */
public class Carrera {

    private ArrayUtil arrayUtil = new ArrayUtil();
    private Apuesta[] totales;
    private int[] resultados = new int[10];
    private Lista<Long> tiemposIngreso = new Lista();
    private Lista<Long> tiemposVerificacion = new Lista();
    private Lista<Long> tiemposProceso = new Lista();
    private Lista<Long> tiemposOrdenamiento = new Lista();
    private Lista<Integer> pasosIngreso = new Lista<>();
    private Lista<Integer> pasosProceso = new Lista<>();
    private Lista<Integer> pasosVerificacion = new Lista<>();
    private Lista<Integer> pasosOrdenamiento = new Lista<>();
    private int buenas;
    private int malas;
    boolean correcto;

    /*
    contar pasos ingreso
    contar tiempo ingreso
    contar pasos verificacion
    contar tiempo de verificacion
    contar pasos proceso
    contar tiempo proceso
    contar pasos ordenamiento
    contar tiempo ordenamiento
        
     */
    public void generarApuestas(int numeroLineas, String texto) {
        long inicio = System.nanoTime();
        String[] lineas = arrayUtil.split(texto, '\n', numeroLineas);
        this.totales = new Apuesta[numeroLineas];
        int pasos = 0;
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] == null) {
                break;
            }
            String[] singleLine = arrayUtil.split(lineas[i], ',', 12);
            Apuesta apuesta = new Apuesta(singleLine[0], singleLine[1], singleLine[2],
                    singleLine[3], singleLine[4], singleLine[5],
                    singleLine[6], singleLine[7], singleLine[8],
                    singleLine[9], singleLine[10], singleLine[11]);
            this.totales[i] = apuesta;
            System.out.println("GENRACION: " + apuesta.toString());
            pasos++;
        }
        if (pasos > 0) {
            this.pasosIngreso.add(pasos);
        }
        long finale = System.nanoTime();
        this.tiemposIngreso.add((finale - inicio));

    }

    public void verificarApuestas() {
        long inicio = System.nanoTime();
        for (Apuesta temp : totales) {
            if (temp == null) {
                temp = new Apuesta();
                continue;
            }
            if (arrayUtil.verificarArreglo(temp.getPosiciones()) == false) {
                temp.setRechazo(true);
            }
            System.out.println("VERIFICACION " + temp.toString());
        }
        int pasos = this.arrayUtil.getPasos();
        if (pasos > 0) {
            this.pasosVerificacion.add(pasos);
            this.arrayUtil.setPasos(0);
        }
        long finale = System.nanoTime();
        this.tiemposVerificacion.add((finale - inicio));
    }

    public void calcularResultados() {
        limpiarResultados();
        int pasos = 0;
        long inicio = System.nanoTime();
        for (int i = 0; i < resultados.length; i++) {
            for (Apuesta temporal : totales) {
                pasos++;
                if (temporal == null) {
                    continue;
                }

                if (temporal.isRechazo() == false) {
                    if (temporal.getPosiciones()[i] == resultados[i]) {
                        temporal.addToPunteo(10 - i);
                    }
                    System.out.println(temporal.toString());
                }
            }
        }
        if (pasos > 0) {
            this.pasosProceso.add(pasos);
        }
        long finale = System.nanoTime();
        this.tiemposProceso.add((finale - inicio));
    }

    private void limpiarResultados() {
        for (Apuesta temp : totales) {
            if (temp != null) {
                temp.setPunteo(0);
            }
        }
    }

    public static String leerArchivo(String nombreArchivo) {

        File archivo = new File(nombreArchivo);
        String contenido = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();

            while (linea != null) {
                contenido += linea + "\n";
                linea = br.readLine();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return contenido;
    }

    public ArrayUtil getArrayUtil() {
        return arrayUtil;
    }

    public void setArrayUtil(ArrayUtil arrayUtil) {
        this.arrayUtil = arrayUtil;
    }

    public Apuesta[] getTotales() {
        return totales;
    }

    public void setTotales(Apuesta[] totales) {
        this.totales = totales;
    }

    public int[] getResultados() {
        return resultados;
    }

    public boolean setResultados(String temp) {
        resultados = new int[10];
        String[] results = arrayUtil.split(temp, ',', 10);
        try {
            for (int i = 0; i < 10; i++) {
                int nuevo = Integer.parseInt(results[i]);
                this.resultados[i] = nuevo;
            }
        } catch (NumberFormatException e) {
            this.resultados = new int[10];
            return false;
        }
        return true;
    }

    public Lista<Long> getTiemposIngreso() {
        return tiemposIngreso;
    }

    public void setTiemposIngreso(Lista<Long> tiemposIngreso) {
        this.tiemposIngreso = tiemposIngreso;
    }

    public Lista<Long> getTiemposVerificacion() {
        return tiemposVerificacion;
    }

    public void setTiemposVerificacion(Lista<Long> tiemposVerificacion) {
        this.tiemposVerificacion = tiemposVerificacion;
    }

    public Lista<Long> getTiemposProceso() {
        return tiemposProceso;
    }

    public void setTiemposProceso(Lista<Long> tiemposProceso) {
        this.tiemposProceso = tiemposProceso;
    }

    public Lista<Integer> getPasosIngreso() {
        return pasosIngreso;
    }

    public void setPasosIngreso(Lista<Integer> pasosIngreso) {
        this.pasosIngreso = pasosIngreso;
    }

    public Lista<Integer> getPasosProceso() {
        return pasosProceso;
    }

    public void setPasosProceso(Lista<Integer> pasosProceso) {
        this.pasosProceso = pasosProceso;
    }

    public Lista<Integer> getPasosVerificacion() {
        return pasosVerificacion;
    }

    public void setPasosVerificacion(Lista<Integer> pasosVerificacion) {
        this.pasosVerificacion = pasosVerificacion;
    }

    public int getBuenas() {
        return buenas;
    }

    public void setBuenas(int buenas) {
        this.buenas = buenas;
    }

    public int getMalas() {
        return malas;
    }

    public void setMalas(int malas) {
        this.malas = malas;
    }

}
