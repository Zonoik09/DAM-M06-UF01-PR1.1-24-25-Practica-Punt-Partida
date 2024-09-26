package com.project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        try {
            gestionarArxius(camiFitxer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void gestionarArxius(String camiFitxer) throws Exception {
        // Convierto el String en un "fichero"/ruta.
        File carpeta = new File(camiFitxer+"/MyFiles");
        // Compruebo si existe y si no existe creo la carpeta y luego con el for creo los archivos con el standar UTF 8.
        if (!(carpeta.exists())) {
            if (!carpeta.mkdir()) {
                throw new Exception("Fallo al crear el directorio");
            }
        }
        for (int i = 1; i < 3; i++) {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(carpeta+"/file" + i + ".txt"), StandardCharsets.UTF_8))) {
                System.out.println("Creando el archivo: file" + i + ".txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            // Tengo que comprobar si existe los archivos para crearlos o no.
            File file = new File(carpeta + "/file1.txt");
            File file1 = new File(carpeta + "/file2.txt");
            File fileRenamed = new File(carpeta + "/renamedFile.txt");
           // if (!file.exists() && !file1.exists() && !fileRenamed.exists()) {
                // Si ninguno de los archivos existe, se crean
            for (int i = 1; i < 3; i++) {
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(carpeta + "/file" + i + ".txt"), StandardCharsets.UTF_8))) {
                    System.out.println("Creando el archivo: file" + i + ".txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        // Renombra l'arxiu file2.txt a renamedFile.txt.

        boolean success = file1.renameTo(fileRenamed);
        List archivos = new ArrayList();
        archivos.addAll(List.of(carpeta.list()));
        // Mostra un llistat dels arxius dins de la carpeta myFiles amb el missatge: “Els arxius de la carpeta són:”.
        if (success == true) {
            System.out.println("Els arxius de la carpeta són:");
            for (int i = 1; i <= archivos.size(); i++) {
                System.out.println("- " + archivos.get(i - 1));
            }
        }

        // Elimina l'arxiu file1.txt.
        if (file.delete())
            System.out.println("El arxiu ha sigut eliminat satisfactoriament");
        else
            System.out.println("El arxiu no ha pogut ser eliminat");
        // Torna a mostrar un llistat dels arxius dins de la carpeta myFiles amb el missatge: “Els arxius de la carpeta són:”.
        archivos.clear();
        archivos.addAll(List.of(carpeta.list()));
        System.out.println("Els arxius de la carpeta són:");
        for (int i = 1; i <= archivos.size(); i++) {
            System.out.println("- " + archivos.get(i - 1));
        }
    }
}
        


