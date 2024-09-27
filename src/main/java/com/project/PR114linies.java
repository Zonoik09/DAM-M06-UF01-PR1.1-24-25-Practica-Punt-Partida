package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PR114linies {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }

    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
        Random random = new Random();
        List<Integer> nums = new ArrayList<>();
        for (int i=0;i <= 9;i++) {
            nums.add(random.nextInt(0,99));
        }
        System.out.println(nums);
        File file = new File(camiFitxer);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), StandardCharsets.UTF_8))) {
            for (int num: nums) {
                bw.write(String.valueOf(num));
                bw.newLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
