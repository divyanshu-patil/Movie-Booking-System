package pkg;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JApp {
    public static void add(Container container, Component... comp) {
        for (Component c : comp) {
            container.add(c);
        }
    }

    // Generic method to add listeners to components
    public static void addListener(String listenerType, Component component, Object data, Runnable action) {
        switch (listenerType) {
            case "ActionListener":
                if (component instanceof AbstractButton) {
                    ((AbstractButton) component).addActionListener(e -> {
                        System.out.println("ActionListener triggered with data: " + data);
                        action.run(); // Perform the specified action

                    });
                } else {
                    throw new IllegalArgumentException(
                            "ActionListener can only be added to AbstractButton components.");
                }
                break;

            case "MouseListener":
                component.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("MouseListener clicked with data: " + data);
                        action.run(); // Perform the specified action
                    }
                });
                break;

            case "KeyListener":
                component.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        System.out.println("KeyListener key pressed with data: " + data);
                        action.run(); // Perform the specified action
                    }
                });
                break;

            default:
                throw new IllegalArgumentException("Unsupported listener type: " + listenerType);
        }
    }

    public static boolean containsDigit(String str) {
        return str.matches(".*\\d.*");
    }

    public static ImageIcon fitImage(String imgPath, int width, int height) {

        ImageIcon imageIcon = new ImageIcon(imgPath);

        Image img = imageIcon.getImage();
        Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }

}
