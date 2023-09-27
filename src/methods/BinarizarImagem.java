package methods;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BinarizarImagem extends ExtrairCores {
    public static void binarizarImagem(BufferedImage imagem) throws IOException {

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();


        BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        int limiar = 128;
        for (int linha = 0; linha < largura; linha++) {
            for (int coluna = 0; coluna < altura; coluna++) {

                int pixel = imagem.getRGB(linha, coluna);
                Color cor = new Color(pixel);

                int valorCinza = (cor.getRed() + cor.getGreen() + cor.getBlue()) / 3;
                if (valorCinza < limiar) {
                    novaImagem.setRGB(linha, coluna, Color.BLACK.getRGB());

                } else {
                    novaImagem.setRGB(linha, coluna, Color.WHITE.getRGB());
                }
            }
        }
        String caminho = CAMINHO_PADRAO + "sombrinhas.jpg";

        ImageIO.write(novaImagem, "jpg", new File(caminho));

        JFrame janela = new JFrame("sombrinhas");
        janela.setSize(1366, 768);
        ImageIcon icon = new ImageIcon(novaImagem);
        JLabel label = new JLabel(icon);
        janela.add(label);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}

