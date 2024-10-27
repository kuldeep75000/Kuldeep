import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class CarGame extends JPanel implements ActionListener {
    private Timer timer;
    private int carX = 250;
    private int carY = 400;
    private int carWidth = 10;
    private int carHeight = 100;
    private int roadWidth = 500;
    private int roadHeight = 500;
    private int obstacleWidth = 10;
    private int obstacleHeight = 50;
    private int speed = 1;
    private ArrayList<Rectangle> obstacles;
    private Random random;

    public CarGame() {
        setPreferredSize(new Dimension(roadWidth, roadHeight));
        setBackground(Color.GRAY);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT && carX > 0) {
                    carX -= 50;
                }
                if (key == KeyEvent.VK_RIGHT && carX < roadWidth - carWidth) {
                    carX += 50;
                }
            }
        });

        obstacles = new ArrayList<>();
        random = new Random();
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(carX, carY, carWidth, carHeight);

        g.setColor(Color.BLACK);
        for (Rectangle obstacle : obstacles) {
            g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < obstacles.size(); i++) {
            Rectangle obstacle = obstacles.get(i);
            obstacle.y += speed;
            if (obstacle.y > roadHeight) {
                obstacles.remove(i);
                i--;
            }
        }

        if (random.nextInt(500) < 10) {
            int x = random.nextInt(roadWidth - obstacleWidth);
            obstacles.add(new Rectangle(x, 0, obstacleWidth, obstacleHeight));
        }

        checkCollision();
        repaint();
    }

    private void checkCollision() {
        for (Rectangle obstacle : obstacles) {
            if (obstacle.intersects(new Rectangle(carX, carY, carWidth, carHeight))) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game Over!", "Game Over", JOptionPane.YES_NO_OPTION);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Car2 Game");
        CarGame game = new CarGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}