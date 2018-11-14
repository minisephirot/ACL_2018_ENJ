package modele.elements;

import com.sun.prism.Texture;
import modele.TextureFactory;

import javax.imageio.ImageIO;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Brique extends Case {
    private BufferedImage imgBrique;
    private BufferedImage imgBriqueProf;
    private int type;

    public Brique(int x, int y, int type)  {
        super(x, y);
        this.type = type;
        imgBrique = TextureFactory.getImgBrique(1);
        imgBriqueProf = TextureFactory.getImgBriqueProf(1);
    }

    public int getType(){
        return type;
    }

    public BufferedImage getImgBrique(){
        return imgBrique;
    }

    public BufferedImage getImgBriqueProf(){
        return imgBriqueProf;
    }


}
