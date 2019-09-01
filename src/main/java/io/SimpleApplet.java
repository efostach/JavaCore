package io;

import java.applet.Applet;
import java.awt.*;

public class SimpleApplet extends Applet {
    public void paint(Graphics g){
        g.drawString("Простейший аплет", 20, 20);
    }
}
