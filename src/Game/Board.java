package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Board extends JPanel implements KeyEventHandler {
    private Map map;
    private Graphics gr;
    private Player[] players;
    private Player player;
    private Monster monster;

    private final int CELLWIDTH = 40;
    private final int CELLHEIGHT = 40;
    private final int LMARGIN = 100;
    private final int TMARGIN = 100;

    public Board(Map map, Player[] players, Monster monster) {
        this.map = map;
        this.players = players;
        this.player = players[0];
        this.monster = monster;
        this.gr = this.getGraphics();
    }

    private int xCor(int col) {
        return LMARGIN + col * CELLWIDTH;
    }

    private int yCor(int row) {
        return TMARGIN + row * CELLHEIGHT;
    }

    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Position cells[][] = map.getAllCells();
        Position cell;
        for (int i=0; i<cells.length; i++) {
            for (int j=0; j<cells[i].length; j++) {
                cell = cells[i][j];
                if (cell.x%5 == 0 && cell.y%5 == 0)
                    gr.setColor(Color.cyan);
                else
                    gr.setColor(Color.white);
                gr.fillRect(xCor(cell.x), yCor(cell.y), CELLWIDTH, CELLHEIGHT);
                gr.setColor(Color.black);
                gr.drawRect(xCor(cell.x), yCor(cell.y), CELLWIDTH, CELLHEIGHT);
            }
        }
        cell = player.getCell();
        gr.setColor(Color.red);
        gr.fillOval(xCor(cell.x)+CELLWIDTH/8, yCor(cell.y)+CELLWIDTH/8, CELLWIDTH*3/4, CELLHEIGHT*3/4);
        gr.setColor(Color.white);
        gr.drawString("P",xCor(cell.x)+CELLWIDTH/3, yCor(cell.y)+2*CELLWIDTH/3);

        cell = monster.getCell();
        gr.setColor(Color.black);
        gr.fillRect(xCor(cell.x), yCor(cell.y), CELLWIDTH, CELLHEIGHT);
        gr.setColor(Color.white);
        gr.drawString("M",xCor(cell.x)+CELLWIDTH/3, yCor(cell.y)+2*CELLWIDTH/3);
    }

    @Override
    public void handleKeyEvent(String keyCode) {
        if (keyCode.compareTo("up") == 0)
            player.setDirection('U');
        else if (keyCode.compareTo("down") == 0)
            player.setDirection('D');
        else if (keyCode.compareTo("left") == 0)
            player.setDirection('L');
        else if (keyCode.compareTo("right") == 0)
            player.setDirection('R');
        else if (keyCode.compareTo("start") == 0)
            player.setReady(true);
    }
}
