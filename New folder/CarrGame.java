import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CarrGame extends JPanel implements ActionListener {

    private int carX = 175;  // Car's initial X position
    private int carY = 400;  // Car's initial Y position
    private final int CAR_WIDTH = 50;
    private final int CAR_HEIGHT = 100;
    private ArrayList<Rectangle> obstacles;
    private Timer timer;
    private int score;
    private BufferedImage carImage;
    private BufferedImage roadImage;

    public  CarrGame() {
        setFocusable(true);
        setPreferredSize(new Dimension(400, 600));
        setDoubleBuffered(true);

        // Load images
        try {
            carImage = ImageIO.read(new File("car.png"));
            roadImage = ImageIO.read(new File("road.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        obstacles = new ArrayList<>();
        score = 0;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (carX > 0) carX -= 10;  // Move left
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (carX < getWidth() - CAR_WIDTH) carX += 10;  // Move right
                        break;
                }
                repaint();  // Redraw the panel
            }
        });

        timer = new Timer(20, this);
        timer.start();
        generateObstacles();
    }

    private void generateObstacles() {
        Random rand = new Random();
        int x = rand.nextInt(getWidth() - 50);  // Random X position for the obstacle
        obstacles.add(new Rectangle(x, 0, 50, 50));  // Add a new obstacle
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw road background
        g.drawImage(roadImage, 0, 0, getWidth(), getHeight(), null);
        
        // Draw the car
        g.drawImage(carImage, carX, carY, CAR_WIDTH, CAR_HEIGHT, null);

        // Draw obstacles
        g.setColor(Color.RED);
        for (Rectangle obstacle : obstacles) {
            g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);  // Draw obstacles
        }

        // Display the score
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 20);  // Display the score
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = obstacles.size() - 1; i >= 0; i--) {
            Rectangle obstacle = obstacles.get(i);
            obstacle.y += 5;  // Move the obstacle down

            // Check for collision
            if (obstacle.intersects(new Rectangle(carX, carY, CAR_WIDTH, CAR_HEIGHT))) {
                timer.stop();  // Stop the game on collision
                JOptionPane.showMessageDialog(this, "Game Over! Your score: " + score);
                System.exit(0);
            }

            // Remove obstacles that are off-screen
            if (obstacle.y > getHeight()) {
                obstacles.remove(i);
                score++;  // Increase score for every obstacle avoided
            }
        }

        // Generate new obstacles
        if (obstacles.size() < 5) {
            generateObstacles();
        }

        repaint();  // Redraw the panel
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Game");
        CarGame game = new CarGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
