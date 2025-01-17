package com.nrj.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private  int x, y;
    private Dir dir = Dir.UP;
    private static final int SPEED = 5;

    Group group = Group.BAD;

    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();
    private boolean moving = true;

    private boolean living = true;

    private Random random = new Random();

    private TankFrame tf;

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public Tank(int x, int y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public void paint(Graphics g) {
        if(!living) {
            tf.tanks.remove(this);
            return;
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
        }
        move();
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private void move() {
        if(!moving) return;
        switch (dir) {
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
        }

        if(random.nextInt(10) > 8 & this.group == Group.BAD) this.fire();
    }

    public void fire() {
        int bulletX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bulletY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bulletX, bulletY, this.dir, this.tf, this.group));
    }

    public void die() {
        living = false;
    }
}
