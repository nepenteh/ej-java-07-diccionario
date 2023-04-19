
package com.jmrh.ejerciciojava07;

import java.util.HashMap;


public class Diccionario {
    private HashMap<String, String> diccionario;
    
    public Diccionario() {
        diccionario = new HashMap<>();
    }
    
    public void nuevoPar(String palEsp, String palIng) {
        diccionario.put(palEsp, palIng);
    }
    
    public String traduce(String palEsp) {
        return diccionario.get(palEsp);
    }
    
    public String palabraAleatoria() {
        int numPal = diccionario.size();
        int numAl = (int) (Math.random() * numPal);
        
        String palEsp = (String) diccionario.keySet().toArray()[numAl];
        
        return palEsp;
    }
    
    public String primeraLetraTraduccion(String palEsp) {
        String palIng = diccionario.get(palEsp);
        return palIng.trim().substring(0,1).toUpperCase();
    }
    
}
