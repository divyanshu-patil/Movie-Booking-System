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

    public static class WrapLayout implements LayoutManager {
        public static final int LEFT = 0;
        public static final int CENTER = 1;
        public static final int RIGHT = 2;

        private int align;
        private int hgap;
        private int vgap;

        public WrapLayout(int align, int hgap, int vgap) {
            this.align = align;
            this.hgap = hgap;
            this.vgap = vgap;
        }

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return layoutSize(parent, true);
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return layoutSize(parent, false);
        }

        @Override
        public void layoutContainer(Container parent) {
            Insets insets = parent.getInsets();
            int maxWidth = parent.getWidth() - insets.left - insets.right;
            int x = 0;
            int y = 0;
            int rowHeight = 0;
            int startX = 0; // For center and right alignment

            // Measure and layout components row by row
            for (int i = 0; i < parent.getComponentCount(); i++) {
                Component comp = parent.getComponent(i);
                Dimension d = comp.getPreferredSize();
                if (x + d.width > maxWidth) {
                    // Align the current row before moving to the next row
                    adjustRow(parent, startX, i, y, maxWidth, rowHeight);
                    x = 0;
                    y += rowHeight + vgap;
                    rowHeight = 0;
                    startX = i;
                }
                x += d.width + hgap;
                rowHeight = Math.max(rowHeight, d.height);
            }

            // Adjust the last row
            adjustRow(parent, startX, parent.getComponentCount(), y, maxWidth, rowHeight);
        }

        private Dimension layoutSize(Container parent, boolean preferred) {
            Insets insets = parent.getInsets();
            int maxWidth = parent.getWidth() - insets.left - insets.right;
            int x = 0;
            int y = 0;
            int rowHeight = 0;
            int count = parent.getComponentCount();

            for (int i = 0; i < count; i++) {
                Component comp = parent.getComponent(i);
                Dimension d = preferred ? comp.getPreferredSize() : comp.getMinimumSize();
                if (x + d.width > maxWidth) {
                    x = 0;
                    y += rowHeight + vgap;
                    rowHeight = 0;
                }
                x += d.width + hgap;
                rowHeight = Math.max(rowHeight, d.height);
            }

            int width = Math.max(x, maxWidth);
            int height = y + rowHeight + insets.top + insets.bottom;
            return new Dimension(width, height);
        }

        // Adjust row alignment based on the selected align (left, center, right)
        private void adjustRow(Container parent, int start, int end, int y, int maxWidth, int rowHeight) {
            int totalWidth = 0;
            for (int i = start; i < end; i++) {
                Component comp = parent.getComponent(i);
                totalWidth += comp.getPreferredSize().width;
            }

            // Add gaps to total width
            totalWidth += (end - start - 1) * hgap;

            // Calculate the starting x position based on alignment
            int x;
            if (align == CENTER) {
                x = (maxWidth - totalWidth) / 2; // Center alignment
            } else if (align == RIGHT) {
                x = maxWidth - totalWidth; // Right alignment
            } else {
                x = 0; // Left alignment (default)
            }

            // Layout the components in the row
            for (int i = start; i < end; i++) {
                Component comp = parent.getComponent(i);
                Dimension d = comp.getPreferredSize();
                comp.setBounds(x, y, d.width, rowHeight);
                x += d.width + hgap;
            }
        }
    }
}
