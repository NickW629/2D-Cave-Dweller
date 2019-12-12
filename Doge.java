package pkg2d.dog.cave.escape;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 629387
 */
public class Doge {
    private int height, width, x, y, vx, vy, hp, xp, score;
    private Rectangle bounds;
    private final int SPEED = 7;
    private boolean alive;
    private ImageIcon ii;
    private Image img;

    
    //Constructor
    public Doge(int cWidth, int cHeight) {
        this.alive = true;
        this.x = cWidth / 2;
        this.y = cHeight / 2;
        this.vx = 0;
        this.vy = 0;
        this.width = 125;
        this.height = 100;
        this.hp = 100;
        this.xp = 0;
        this.score = 0;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
        this.ii = new ImageIcon(getClass().getResource("banana.png"));
        this.img = ii.getImage();
        this.ii = new ImageIcon(getClass().getResource("75 health.png"));
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

    public int getVy() {
        return vy;
    }

    public boolean isAlive() {
        return alive;
    }

    public Rectangle getBounds() {
        return bounds;
    }
    
    //Methods
    public void die() {
        this.alive = false;
    }
    public void takehit(){
     hp-=25;
     System.out.println("you lost health");
     System.out.print(hp);
     if (hp<=0)
         System.exit(width);
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
    
    public void draw(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
        
    }
    
    public void collect() {
        
    }
    
    public void update() {
        this.x += vx;
        this.y += vy;
        this.bounds = new Rectangle(this.x, this.y, this.width, this.height);
    }

    public void stop() {
        this.vx = 0;
        this.vy = 0;
    }
}

