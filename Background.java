/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2d.cave.dweller;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
/**
 *
 * @author 629387
 */
public class Background {
     private int height, width, x, y ;
    private Rectangle bounds;
    private ImageIcon ii;
    private Image img;
    
    public Background (int cWidth,int cHeight){
        this.width = 1600;
        this.height = 900;
        this.x = cWidth / 2;
        this.y = cHeight / 2;
         this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
        this.ii = new ImageIcon(getClass().getResource("cave.jpg"));
        this.img = ii.getImage();
    }
        public void draw(Graphics g) {
      g.drawImage(img, x, y, width, height, null);
   }
        public void update() {
      this.bounds=new Rectangle(this.x,this.y,this.width,this.height);
    }
  }
        
