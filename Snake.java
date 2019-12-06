/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2d.cave.dweller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
 *
 * @author 629387
 */
public class Snake {
  private int  height, width, x, y,vx,vy;
  private Rectangle bounds;
  private Color color;
  private final int SPEED = 4;
   private boolean alive;

  public Snake (int cWidth,int cHeight){
      this.alive=true;
      this.x = cWidth;
      this.y = (int) (Math.random()*cHeight);
      this.width=10;
      this.height=10;
      this.color=Color.GREEN;
      this.bounds=new Rectangle(this.x,this.y,this.width,this.height);
  }
       public boolean isAlive() {
        return alive;
    }
       
       
       
       
       
       
       
       
        public void draw(Graphics g) {
      g.setColor(this.color);
      Graphics2D g2d= (Graphics2D) g;
      g.drawRoundRect(x, y, width, height, width, height);
      g.fillRoundRect(x, y, width, height, width, height);
   }
        public void update() {
      this.bounds=new Rectangle(this.x,this.y,this.width,this.height);
    }
  }

