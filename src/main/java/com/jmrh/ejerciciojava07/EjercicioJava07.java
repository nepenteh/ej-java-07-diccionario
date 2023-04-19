package com.jmrh.ejerciciojava07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author josep
 */
public class EjercicioJava07 {

    private static Diccionario diccionarioEspIng = new Diccionario();
    private static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        rellenarDiccionario();
        juego();

    }

    private static void rellenarDiccionario() {

        try {
            File fichero = new File("palabras.txt");
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                String array[] = linea.split(";");
                diccionarioEspIng.nuevoPar(array[0], array[1]);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error en la lectura desde el archivo");
        }

    }

    private static void juego() {
        String palEsp;
        String letraIng;
        String respuesta;
        String palIng;
        
        int totPreg = 0;
        int totAciertos = 0;
        int totErrores = 0;
        double porcentaje = 0.0;

        do {
            palEsp = diccionarioEspIng.palabraAleatoria();
            letraIng = diccionarioEspIng.primeraLetraTraduccion(palEsp);

            System.out.println(palEsp + ": " + letraIng + "...");
            System.out.println("Indique la respuesta: ");
            respuesta = lector.nextLine();

            if(!respuesta.equalsIgnoreCase("fin")) {
                totPreg++;
                palIng = diccionarioEspIng.traduce(palEsp);
                if (respuesta.equalsIgnoreCase(palIng)) {
                    System.out.println("¡¡CORRECTO!!");
                    totAciertos++;
                } else {
                    System.out.println("¡NO! La respuesta correcta es " + palIng);
                    totErrores++;
                }
                
            }            
            
        } while (!respuesta.equalsIgnoreCase("fin"));

        porcentaje = ((double) totAciertos / (double) totPreg) * 100.0;
        
        System.out.println("Total de preguntas: "+totPreg);
        System.out.println("Total de aciertos: "+totAciertos);
        System.out.println("Totasl de errores: "+totErrores);
        System.out.println("Aciertos: "+porcentaje+"%");
        
    }
}
