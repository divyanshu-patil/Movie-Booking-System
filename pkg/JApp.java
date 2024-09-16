package pkg;

import java.awt.*;

public class JApp {
    public static void add(Container container, Component... comp) {
        for (Component c : comp) {
            container.add(c);
        }
    }
}
