/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3_nicolasbuitragosuarez_jairarboledapineda;

/**
 *
 * @author Nicolás
 */
public class Libro {
    private final int codigo;
    private final String titulo;
    private final String autor;
    private boolean estado;
    private Fecha fechaDevolucion;
    private int codigoAfiliado;

    public Libro(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = true;
        this.fechaDevolucion = new Fecha("0/0/0");
        this.codigoAfiliado = -1;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isEstado() {
        return estado;
    }

    public Fecha getFechaDevolucion() {
        return fechaDevolucion;
    }

    public int getCodigoAfiliado() {
        return codigoAfiliado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFechaDevolucion(Fecha fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setCodigoAfiliado(int codigoAfiliado) {
        this.codigoAfiliado = codigoAfiliado;
    }

    
}
