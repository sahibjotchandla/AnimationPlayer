/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shapetester;

import java.awt.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Polygon;
import java.awt.Paint;
import javafx.application.Application;
import java.awt.Stroke;

public class ShapeTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setBounds(700, 250, 500, 500); //x-int for frame, y-int for frame, length of frame, width of frame
        fr.setDefaultCloseOperation(3);
        JPanel pn = new JPanel(){
            //@Override
            public void paint(Graphics g){
                Graphics2D shape = (Graphics2D) g; 
                shape.setColor(new Color(174,33,255)); //set colour (R,G,B)
                shape.fillOval(10,40,100,100); //x-position, y-position, Diameter, Diameter

                shape.setColor(new Color(0,255,0));
                shape.setStroke(new BasicStroke(5)); //Border thickness set to 5
                shape.drawOval(10, 40, 100, 100);

                g.setColor(new Color(255,33,155));
                g.fillRect(200, 200, 100, 200);   //x-position, y-position, length, width

                shape.setColor(new Color(255,0,0));
                shape.setStroke(new BasicStroke(5));
                shape.drawLine(0,0,500,500); //x-position, y-position, Length, Width
            }
        };
    fr.add(pn);
    fr.setVisible(true);
    }
    
}
