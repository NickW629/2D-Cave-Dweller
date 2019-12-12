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
public class Bomb {
    private int height, width, x, y;
    private Rectangle bounds;
    private boolean alive;
    private ImageIcon ii;
    private Image img;
    //Constructor
    public Bomb (int cWidth,int cHeight){
      this.alive=true;
      this.x = (int) (Math.random()*cWidth);
      this.y = (int) (Math.random()*cHeight);
      this.width=20;
      this.height=20;
      this.bounds=new Rectangle(this.x,this.y,this.width,this.height);
      this.ii = new ImageIcon(getClass().getResource("Bomb.png"));
      this.img = ii.getImage();
  }
   public boolean isAlive() {
        return alive;
    }

    public Rectangle getBounds() {
        return bounds;
    }
  public void explode() {
      this.alive=false;
      
  }
  
   public void draw(Graphics g) {
     g.drawImage(img, x, y, width, height, null);
      
   }
    public void update() {
     this.bounds=new Rectangle(this.x,this.y,this.width,this.height);
    }
}

