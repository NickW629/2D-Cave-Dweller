/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2d.dog.cave.escape;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author 629387
 */
public class Exit {
    private int  height, width, x, y;
    private Rectangle bounds;
    private ImageIcon ii;
    private Image img;
    
     public Exit (int cWidth,int cHeight){
          this.x = (int) (Math.random()*cWidth);
      this.y = (int) (Math.random()*cHeight);
      this.width=100;
      this.height=100;
      this.bounds=new Rectangle(this.x,this.y,this.width/3,this.height);
      this.ii = new ImageIcon(getClass().getResource("Door.png"));
      this.img = ii.getImage();
     }
        public Rectangle getBounds() {
        return bounds;
    }
        public void draw(Graphics g) {
     g.drawImage(img, x, y, width, height, null);
      
   }
    public void update() {
     this.bounds=new Rectangle(this.x,this.y,this.width,this.height);
    }
    
}

     
    

