/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redblackbst;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;

/**
 *
 * @author Łukasz Knigawka
 */
public class Loop extends Canvas implements Runnable{
    
    
    int width, height;
    RedBlackBST<Integer, Integer> tree;
    private boolean running;
    public Loop() {
        this.height = 800;
        this.width = 1000;
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.tree = new RedBlackBST<>(width / 2);
        for(int i = 0; i < 10; i++) {
            tree.put(i, i);
        }
        System.out.println("loop 30");
    }
    
    public void draw() {
        this.getParent().repaint();
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics2D g = (Graphics2D)bs.getDrawGraphics();
        tree.drawTree(g, tree.getRoot(), 0, 0, 0);
        bs.show();
        System.out.println("asd");        
        g.dispose();
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
        running = true;
    }
    
    @Override
    public void run() {
        while(running) {
            for(int i = 0; i < 10; i++) {
                tree.put(i, i);
                try {
                TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                draw();
            }
        }
    }
    
    
    
    
    
}
