package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PR112cat {

    public static void main(String[] args) {
        // Comprovar que s'ha proporcionat una ruta com a paràmetre
//        if (args.length == 0) {
//            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
//            return;
//        }

        // Obtenir la ruta del fitxer des dels paràmetres
        String rutaArxiu = System.getProperty("user.dir") + "/data/PR112/arxhivo.txt";
        mostrarContingutArxiu(rutaArxiu);
    }

    // Funció per mostrar el contingut de l'arxiu o el missatge d'error corresponent
    public static void mostrarContingutArxiu(String rutaArxiu) {
        try {
            File file = new File(rutaArxiu);
            if (!file.exists()) {
                System.out.println("El fitxer no existeix o no és accessible.");
            }
            else if (!file.isDirectory()) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
                    String linia;
                    while ((linia = br.readLine()) != null) {
                        System.out.println(linia);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
