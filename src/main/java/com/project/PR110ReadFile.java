package com.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PR110ReadFile {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer);  // Només cridem a la funció amb la ruta del fitxer
    }

    // Funció que llegeix el fitxer i mostra les línies amb numeració
    public static void llegirIMostrarFitxer(String camiFitxer) {
        int counter = 1;
        File fitxer = new File(camiFitxer);
        try (Scanner scanner = new Scanner(fitxer)) {
            while (scanner.hasNextLine()) {
                String linia = scanner.nextLine();
                System.out.println(counter+": "+linia);
                counter ++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo de la siguiente ruta no existe o no se ha encontrado: " + camiFitxer);
            crearArchivo(camiFitxer);
        }
    }

    // Si no existe ese archivo abra la posibilidad de crear un archivo con el nombre que ha puesto.
    public static void crearArchivo(String archivo) {
        BufferedWriter bw;
        System.out.println("Quieres crear el archivo? (S/N)");
        Scanner scanner0 = new Scanner(System.in);
        String respuesta = scanner0.nextLine().toUpperCase();
        if (respuesta.equals("S")) {
            try {
                bw = new BufferedWriter(new FileWriter(archivo));
                System.out.println("Creando el archivo...");
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Cerrando programa...");
        }
            
         
    }
}
 