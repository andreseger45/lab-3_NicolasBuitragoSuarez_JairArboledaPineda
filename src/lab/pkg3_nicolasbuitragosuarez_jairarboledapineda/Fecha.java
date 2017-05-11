/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3_nicolasbuitragosuarez_jairarboledapineda;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Nicolás
 */
public class Fecha {
    private int dia;
    private int mes;
    private int año;
    
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    public Fecha(String date) {
        String[] fecha = date.split("/");
        this.dia = Integer.parseInt(fecha[0]);
        this.mes = Integer.parseInt(fecha[1]);
        this.año = Integer.parseInt(fecha[2]);
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }
    
    public Fecha devolucion(Date fecha) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, 4);
        return new Fecha(new java.text.SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));

    }
    
    public String getFecha(){
        String dia,mes;
        if(this.dia<10) {dia = "0"+this.dia;}else{dia = Integer.toString(this.dia);}
        if (this.mes<10){ mes = "0"+this.mes;}else{mes = Integer.toString(this.mes);}
        return dia+"/"+mes+"/"+this.año;
    }
    
    public long diferencia(Fecha fechaHoy) {
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
//        java.util.Date hoy = new Date(); //Fecha de hoy 

//        int año = 2017, mes = 5, dia = 14; //Fecha devolucion
        Calendar calendard = new java.util.GregorianCalendar(this.año, this.mes - 1, this.dia);
        Calendar calendarh = new java.util.GregorianCalendar(fechaHoy.año, fechaHoy.mes - 1, fechaHoy.dia);
        java.sql.Date devolucion = new java.sql.Date(calendard.getTimeInMillis());
        java.sql.Date hoy = new java.sql.Date(calendarh.getTimeInMillis());
        
        long diferencia = (hoy.getTime() - devolucion.getTime()) / MILLSECS_PER_DAY;
//        if(diferencia<0) diferencia--;
        System.out.println("diferencia = "+diferencia);
        return diferencia;
    }
    
    public boolean igual(Fecha fecha){
        return this.año==fecha.getAño()&&this.mes==fecha.getMes()&&this.dia==fecha.getDia();
    }
    
    public boolean mayor (Fecha fecha){System.out.println("");System.out.println("");
        if(this.getAño()>fecha.getAño()){System.out.println(this.getAño()+" Año mayor "+fecha.getAño());
            return true;
        }else if(this.getAño()== fecha.getAño()){System.out.println(this.getAño()+" Años iguales "+fecha.getAño());
            if(this.getMes()>fecha.getMes()){System.out.println(this.getMes()+" Mes mayor "+fecha.getMes());
                return true;
            }else if(this.getMes()==fecha.getMes()){System.out.println(this.getMes()+" Meses iguales "+fecha.getMes());
                if(this.getDia()>fecha.getDia()){ System.out.println(this.getDia()+" Dia mayor "+fecha.getDia());
                    return true;
                }else if(this.getDia()==fecha.getDia()){System.out.println(this.getDia()+" Dias igaules "+fecha.getDia());
                    return true;
                }else {System.out.println(this.getDia()+" Dia menor "+fecha.getDia());
                    return false;
                }
            } else {System.out.println(this.getMes()+" Mes menor "+fecha.getMes());
                return false;
            }
        } else {System.out.println(this.getAño()+" Año menor "+fecha.getAño());
            return false;
        }
    }
}
