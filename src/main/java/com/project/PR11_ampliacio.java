package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.vdurmont.emoji.*;

public class PR11_ampliacio {
    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/emojis.txt";
        copiarArxiu(camiFitxer);
    }

    public static void copiarArxiu(String camiFitxer) {
        File file = new File(camiFitxer);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), StandardCharsets.UTF_8))) {
            List<Emoji> allEmojis = (List<Emoji>) EmojiManager.getAll();
            bw.write("Emoji" + " | " + "Alias\n");
            for (Emoji emoji : allEmojis) {
                bw.write(emoji.getUnicode() + " | " + emoji.getAliases());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("El fichero con todos los emojis con su alias se ha creado exitosamente");
    }


}
