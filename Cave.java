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
    private Snake snake;
    private Exit exit;
    private Background background;
    private ArrayList<Bomb> bombs =new ArrayList<>();

    public Cave() {
        super();
        background=new Background(0,0);
        snake=new Snake(800,600);
        player = new Doge(800, 600);
        timer = new Timer();
        exit = new Exit(800,600);
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
        for(int i=0; i<25; i++){
        Bomb temp= new Bomb(1400,800);
        bombs.add(temp);
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
        
            
        
             
  
        if (snake.isAlive()) snake.draw(g);
          for(Bomb bomb : bombs){
            if (bomb== null || !bomb.isAlive())
                continue;
                bomb.draw(g);
        }

        
//        int counter = 0;
//        while(counter < 20) {
//            if (counter % 3 == 0) {
//                g.setColor(Color.RED);
//            }
//            else {
//                g.setColor(Color.GREEN);
//            }
//            
//            g.fillRect(30*counter,30*counter,25,25);
//            counter++;
//        }
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            background.update();
            player.update();
            snake.update();
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
    }

    private void checkCollisions() {
      
                //System.exit(0);
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
