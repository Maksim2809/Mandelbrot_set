package ru.smak.gui.graphics;

import java.awt.*;

public class SelectionPainter {

    private boolean isVisible = false;
    private Point startPoint = null;
    private Point currentPoint = null;
    private Graphics g;

    private Point notBug1 = null;
    private Point notBug2 = null;

    public SelectionPainter(Graphics g){
        this.g = g;
    }

    public void setGraphics(Graphics g){
        this.g = g;
    }

    public void setVisible(boolean value){
        if (!value){
            paint();
            notBug1 = startPoint;
            notBug2 = currentPoint;
            currentPoint = null;
            startPoint = null;
        }
        isVisible = value;
    }

    public void setStartPoint(Point p){
        startPoint = p;
    }

    public void setCurrentPoint(Point p){
        if (currentPoint!=null)
            paint();
        currentPoint = p;
        paint();
    }

    private void paint(){
        if (startPoint!=null && currentPoint!=null) {
            g.setXORMode(Color.WHITE);
            // 11111111 11111111 11111111 - background
            // 11111111 11111111 11111111 - XOR Mode Color
            // 11111111 00000000 00000000 - foreground
            // --------------------------
            // 11111111 00000000 00000000 - новый цвет пискселя (new background)
            g.setColor(Color.BLACK);
            g.drawRect(Math.min(startPoint.x, currentPoint.x), Math.min(startPoint.y,currentPoint.y),
                    Math.abs(currentPoint.x - startPoint.x),
                    Math.abs(currentPoint.y - startPoint.y));
            g.setPaintMode();
        }
    }
    public Point  getPoint(boolean b){
        if (b) return notBug1;
        else return notBug2;
    }
}
