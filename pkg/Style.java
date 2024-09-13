package pkg;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Style {

    public static JButton createButton(String msg) {
        JButton b = new JButton(msg);
        b.setBackground(Style.ColorConstants.BTN_COLOR);
        b.setFont(new Font("Arial", Font.BOLD, 25));
        b.setForeground(Color.WHITE);
        b.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                b.setBackground(Style.ColorConstants.LIGHTBLUE_COLOR);
            }

            public void mouseExited(MouseEvent e) {
                b.setBackground(Style.ColorConstants.BTN_COLOR);

            }
        });

        return b;
    }

    public static void applyPercentageMargins(Component container, JPanel content, double horizontalPercent,
            double verticalPercent) {
        // Calculate margins based on container size
        int containerWidth = container.getWidth();
        int containerHeight = container.getHeight();

        int horizontalMargin = (int) (containerWidth * horizontalPercent);
        int verticalMargin = (int) (containerHeight * verticalPercent);

        // Set the border with the calculated margins
        content.setBorder(
                BorderFactory.createEmptyBorder(verticalMargin, horizontalMargin, verticalMargin, horizontalMargin));

        // Revalidate and repaint the content panel to apply the changes
        content.revalidate();
        content.repaint();
    }

    public static void applyPercentageSize(Component container, Component content, double widthPercent,
            double heightPercent) {
        // Calculate sizes based on container size
        int containerWidth = container.getWidth();
        int containerHeight = container.getHeight();

        int contentWidth = (int) (containerWidth * widthPercent);
        int contentHeight = (int) (containerHeight * heightPercent);

        // Set the size of the content panel
        content.setPreferredSize(new Dimension(contentWidth, contentHeight));

        // Revalidate and repaint the content panel to apply the changes
        content.revalidate();
        content.repaint();
    }

    public static class ColorConstants {
        public static final Color BGCOLOR = new Color(38, 41, 43);
        public static final Color LIGHTBG_COLOR = new Color(46, 50, 57);
        public static final Color BTN_COLOR = new Color(95, 122, 219);
        public static final Color LIGHTBLUE_COLOR = new Color(162, 178, 238);

    }
}
