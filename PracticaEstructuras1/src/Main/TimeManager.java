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
public class TimeManager {
    public String getTime(long nanoSeconds){
        long tiempo = TimeUnit.MILLISECONDS.convert(nanoSeconds,TimeUnit.NANOSECONDS);
        if (tiempo == 0) {
            tiempo = TimeUnit.MICROSECONDS.convert(nanoSeconds,TimeUnit.NANOSECONDS);
            if (tiempo == 0) {
                return tiempo+" Nanosegundos";
            }else{
                return tiempo+" Microsegundos";
            }
        }else{
            return tiempo+" Milisegundos";
        }
    }
}
