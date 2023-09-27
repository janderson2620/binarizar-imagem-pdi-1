package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import static methods.BinarizarImagem.binarizarImagem;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedImage bandas = ImageIO.read(
                new File("C:\\Users\\jande\\IdeaProjects\\project-binarizando\\src\\imagens\\logoOriginal\\sombrinhas.jpg\\")
        );
        binarizarImagem(bandas);

    }
}

