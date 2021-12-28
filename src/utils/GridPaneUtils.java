package utils;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public final class GridPaneUtils {
    private GridPaneUtils() {
    }

    public static int getRowIndex(Object object) {
        Integer res = GridPane.getRowIndex((Node) object);
        return res != null ? res : 0;
    }

    public static int getColumnIndex(Object object) {
        Integer res = GridPane.getColumnIndex((Node) object);
        return res != null ? res : 0;
    }
}
