import Game.*;
import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private Player[] players;
    private Player player;
    private Monster monster;
    private Map map;
    private Board gameBoard;
    private final int TIMEALLOWED = 100;

    public Game() {
        this.map = new Map();
        this.players = new Player[]{ new Player(this.map,0 ,0) };
        this.player = players[0];
        this.monster = new Monster(map, players, 5, 5);
        this.gameBoard = new Board(map, players, monster);

        (new KeyBoard()).keyBoardListener(gameBoard);
        (new KeyBoard()).keyEventRegister(gameBoard);

        gameBoard.setFocusable(true);
        gameBoard.requestFocusInWindow();

        add(this.gameBoard, BorderLayout.CENTER);
    }

    public void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int time = 0;
        String message;
        player.setDirection(' '); // set to no direction
        while (!player.isReady()) {
            delay(100);
        }
        do {
            Position newPlayerCell = player.move();
            if (newPlayerCell == monster.getPosition())
                break;
            player.setDirection(' ');   // reset to no direction

            Position newMonsterCell = monster.move();
            if (newMonsterCell == player.getPosition()) {
                break;
            }

            // update time and repaint
            time++;
            delay(1000);
            gameBoard.repaint();

        } while (time < TIMEALLOWED);

        if (  time < TIMEALLOWED) {
            message = "Player Lost";
        } else {
            message = "Player Won";
        }
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.setTitle("Pacman Game");
        game.setSize(700,700);
        game.setLocationRelativeTo(null);  // center the frame
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
        game.start();
    }
}
