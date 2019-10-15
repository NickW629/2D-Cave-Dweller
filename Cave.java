/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2d.cave.dweller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author 629387
 */
 public class Cave extends JPanel {
    private Timer timer;
    private CaveMan player;
    private Bomb bomb;

    public Cave() {
        super();
        player = new CaveMan(800, 600);
        bomb = new Bomb(800, 600);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.GRAY);
        if (bomb.isAlive()) bomb.draw(g);
        if (player.isAlive()) player.draw(g);
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
            
            bomb.update();
            player.update();
            checkCollisions();
            repaint();
        }
    }
    
    private void checkCollisions() {
        if (player.getBounds().intersects(bomb.getBounds())) {
            if (player.getVy() > 0) {
                System.out.println("Bomb detonated");
                bomb.explode();
            }
            else {
                player.takehit();
                //System.exit(0);
            }
            System.out.println("collision!");
        }
        else {
            
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
