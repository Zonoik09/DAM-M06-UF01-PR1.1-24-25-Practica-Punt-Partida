package com.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        gestionarArxius(camiFitxer);
    }

    public static void gestionarArxius(String camiFitxer) {
        // Convierto el String en un "fichero"/ruta.
        File carpeta = new File(camiFitxer);
        // Compruebo si existe y si no existe creo la carpeta y luego con el for creo los archivos con el standar UTF 8.
        if (!(carpeta.exists())) {
            carpeta.mkdir();
            for (int i = 1; i < 3; i++) {
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(camiFitxer+"/file" + i + ".txt"), StandardCharsets.UTF_8))) {
                    System.out.println("Creando el archivo: file" + i + ".txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            // Tengo que comprobar si existe los archivos para crearlos o no.
            File file = new File(camiFitxer+"\\file1.txt");
            File file1 = new File(camiFitxer+"\\file2.txt");
            if (!(file.exists() && file1.exists())) {
                for (int i = 1; i < 3; i++) {
                    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(camiFitxer + "/file" + i + ".txt"), StandardCharsets.UTF_8))) {
                        System.out.println("Creando el archivo: file" + i + ".txt");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        
        
    }
}
