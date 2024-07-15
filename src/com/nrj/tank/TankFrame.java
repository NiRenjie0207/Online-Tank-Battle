package com.nrj.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x = 300;
    int y = 250;
    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setVisible(true);
        setTitle("Tank War");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(350, 250, 50, 50);
    }
}
