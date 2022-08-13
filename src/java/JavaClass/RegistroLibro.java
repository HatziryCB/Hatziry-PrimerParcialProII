/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaClass;

/**
 *
 * @author Hatziry Chacón
 */
public class RegistroLibro {
    Libros[] vectorLibros;
    int indice;

    public RegistroLibro() {
        this.vectorLibros = new Libros[50];
        this.indice = 0;
    }
    
    public void almacenar(Libros libro){
        this.vectorLibros[indice]=libro;
        this.indice=indice+1;
    }
    
    public Libros[] mostrar(){
        return this.vectorLibros;
    }
}

