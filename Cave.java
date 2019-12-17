/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2d.dog.cave.escape;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author 629387
 */
 public class Cave extends JPanel {
    private Timer timer;
    private Doge player;
    private Exit exit;
    private Background background;
    private ArrayList<Bomb> bombs =new ArrayList<>();
    private ArrayList<Snake> snakes =new ArrayList<>();

    public Cave() {
        super();
   
        background=new Background(0,0);
        player = new Doge(800, 600);
        timer = new Timer();
        exit = new Exit(800,600);
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
        for(int i=0; i<25; i++){
        Bomb temp= new Bomb(1200,800);
        bombs.add(temp);
        }
        for(int i=0; i<5; i++){
        Snake temp= new Snake(1200,800);
        snakes.add(temp);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.draw(g);
        exit.draw(g);
        if (player.isAlive()){
             player.draw(g);
        }
             for(Snake snake : snakes){
            if (snake== null || !snake.isAlive())
                continue;
                snake.draw(g);
        }
          for(Bomb bomb : bombs){
            if (bomb== null || !bomb.isAlive())
                continue;
                bomb.draw(g);
          }
    }
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            background.update();
            player.update();
            for (Snake snake : snakes){
                if (snake== null || !snake.isAlive())
                    continue;
                    snake.update();
                    SnakeVsPlayer(snake);
               }
            exit.update();
               for (Bomb bomb : bombs){
                if (bomb== null || !bomb.isAlive())
                    continue;
                    bomb.update();
                    BombVsPlayer(bomb);
               }
            checkCollisions();
            boundaries();
            repaint();
        }
    }
       private void SnakeVsPlayer(Snake snake){
            if(snake.isAlive() && snake.getBounds().intersects(player.getBounds())){
                player.takehit();
                snake.die();
            }
       }
     private void BombVsPlayer(Bomb bomb){
            if(bomb.isAlive() && bomb.getBounds().intersects(player.getBounds())){
                player.takehit();
                bomb.explode();
            }
     }
    
        public void boundaries() {
            if(player.getX()<=0){
                player.setX(0);
            }
                  if(player.getX()>=1350){
                player.setX(1350);
                  }
                if (player.getY()<=0){
                player.setY(0);
                }
                if (player.getY()>=800){
                      player.setY(800);
                  }
                
              for(Snake snake:snakes){ 
                  if(snake.getX()<=0){
                snake.setVx(4);
            }
                  if(snake.getX()>=1350)
                      snake.setVx(-4);
           }
                
    }

    private void checkCollisions() {
        if(player.isAlive() && exit.getBounds().intersects(player.getBounds())){
           System.out.println("You Win");
           restart(1600,900);
            }
         }
    private void restart (int cWidth,int cHeight){
       if(player.isAlive() && exit.getBounds().intersects(player.getBounds())){
        player.setX(1400);
        player.setHp(100);
        for(int i=0; i<15; i++){
        Bomb temp= new Bomb(1200,800);
        bombs.add(temp);
        }
         for(int i=0; i<2; i++){
        Snake temp= new Snake(1200,800);
        snakes.add(temp);
        }
        }
    }
   
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.move("right");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.move("left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.move("up");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.move("down");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.stop();
        }
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.stop();
        }
            
    }
}
