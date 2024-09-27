package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PR115cp {

    public static void main(String[] args) {
//        if (args.length != 2) {
//            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
//            System.out.println("Ús: PR115cp <origen> <destinació>");
//            return;
//        }

        // Ruta de l'arxiu origen
        String rutaOrigen = System.getProperty("user.dir") + "/data/PR115/copiar.txt";
        // Ruta de l'arxiu destinació
        String rutaDesti = System.getProperty("user.dir") + "/data/PR115/desti.txt";

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        File origen = new File(rutaOrigen);
        File desti = new File(rutaDesti);

        if (origen.exists() && origen.isFile()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(origen), StandardCharsets.UTF_8))) {
                String linia;
                while ((linia = br.readLine()) != null) {;
                    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desti,true), StandardCharsets.UTF_8))) {
                        bw.write(linia);
                        bw.newLine();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
