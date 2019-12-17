/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2d.dog.cave.escape;
import java.awt.Color;
import java.awt.Graphics;
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
      this.x = (int) (Math.random()*cWidth);
      this.y = (int) (Math.random()*cHeight);
      this.width=10;
      this.height=10;
      this.color=Color.GREEN;
      this.vx=SPEED;
      this.vy=0;
      this.bounds=new Rectangle(this.x,this.y,this.width,this.height);
  }
       public boolean isAlive() {
        return alive;
    }
        public Rectangle getBounds() {
        return bounds;
    }
      public void move(String direction) {
      if (direction.equals("right"))
        vx = SPEED;
      else if (direction.equals("left"))
          vx = -SPEED;
       else if (direction.equals("up"))
          vy = -SPEED;
       else if (direction.equals("down"))
          vy = SPEED;
  }
       public void die() {
        this.alive = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }
       
        public void draw(Graphics g) {
      g.setColor(this.color);
      g.drawRoundRect(x, y, width, height, width, height);
      g.fillRoundRect(x, y, width, height, width, height);
   }
        public void update() {
      this.bounds=new Rectangle(this.x,this.y,this.width,this.height);
      this.x+=vx;
      this.y+=vy;
    }
        
  }

