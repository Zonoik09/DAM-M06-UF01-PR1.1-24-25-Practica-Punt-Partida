package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PR113sobreescriu {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que escriu les frases sobreescrivint el fitxer
        escriureFrases(camiFitxer);
    }

    // Mètode que escriu les frases sobreescrivint el fitxer amb UTF-8 i línia en blanc final
    public static void escriureFrases(String camiFitxer) {
        File file = new File(camiFitxer);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), StandardCharsets.UTF_8))) {
            bw.write("I can only show you the door");
            bw.newLine();
            bw.write("You're the one that has to walk through it");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
