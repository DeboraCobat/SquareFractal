import javax.swing.*;
import java.awt.*;

public class SquareFractal extends JPanel {

    private static final Color[] COLORS = {Color.BLACK, Color.GREEN, Color.BLUE, Color.ORANGE};

    public static void main(String[] args) {
        JFrame frame = new JFrame("Square Fractal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        SquareFractal fractal = new SquareFractal();
        frame.add(fractal);

        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFractal(g, getWidth() / 2, getHeight() / 2, getWidth() / 3, 0);
    }

    private void drawFractal(Graphics g, int x, int y, int size, int level) {
        g.setColor(COLORS[level % COLORS.length]);
        g.drawRect(x - size / 2, y - size / 2, size, size);

        int smallerSize = size / 3;

        int leftX = x - size / 2 - smallerSize;
        int leftY = y - smallerSize / 2;

        int topX = x - smallerSize / 2;
        int topY = y - size / 2 - smallerSize;

        int rightX = x + size / 2;
        int rightY = y - smallerSize / 2;

        int bottomX = x - smallerSize / 2;
        int bottomY = y + size / 2;

        g.setColor(COLORS[(level + 1) % COLORS.length]);
        g.drawRect(topX, topY, smallerSize, smallerSize);
        g.drawRect(rightX, rightY, smallerSize, smallerSize);
        g.drawRect(leftX, leftY, smallerSize, smallerSize);
        g.drawRect(bottomX, bottomY, smallerSize, smallerSize);

        if (level < 2) {
            g.setColor(COLORS[(level + 2) % COLORS.length]);
            drawFractal(g, leftX + smallerSize / 2, leftY + smallerSize / 2, smallerSize, level + 1);
            drawFractal(g, topX + smallerSize / 2, topY + smallerSize / 2, smallerSize, level + 1);
            drawFractal(g, rightX + smallerSize / 2, rightY + smallerSize / 2, smallerSize, level + 1);

            if (level == 1) {
                drawFractal(g, bottomX + smallerSize / 2, bottomY + smallerSize / 2, smallerSize, level + 1);
            }
        }
    }
}
