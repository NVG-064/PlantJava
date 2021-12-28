package lib;

import javafx.scene.control.Button;
import utils.GridPaneUtils;

public class Garden {
    private Plant plantList[][] = new Plant[3][3];

    private int selectedRow;
    private int selectedColumn;

    public void setSelectedPlant(Button button) {
        selectedRow = GridPaneUtils.getRowIndex(button);
        selectedColumn = GridPaneUtils.getColumnIndex(button);
    }

    public void setSelectedPlantValue(Plant plant) {
        plantList[selectedRow][selectedColumn] = plant;
    }

    public Plant getSelectedPlant() {
        return plantList[selectedRow][selectedColumn];
    }

    public Plant getPlantInGrid(Button button) {
        int row = GridPaneUtils.getRowIndex(button);
        int column = GridPaneUtils.getColumnIndex(button);
        return plantList[row][column];
    }
}
