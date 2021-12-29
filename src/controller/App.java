package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lib.Flower;
import lib.Garden;
import lib.Plant;

public class App extends Application {

    // Injected fxml id
    @FXML
    private Label lblTotalPoints;
    @FXML
    private Label lblPlantStage;
    @FXML
    private Label lblWaterCount;
    @FXML
    private Label lblFertilizerCount;
    @FXML
    private GridPane gridPlant;
    @FXML
    private Group groupPlantEmpty;
    @FXML
    private Group groupPlantSelected;
    @FXML
    private Button btnHarvest;

    // Field declaration
    enum PlantMode {
        UNSELECTED,
        EMPTY,
        SELECTED,
    }

    private Garden garden = new Garden();
    private Button selectedButton;
    private Integer points = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/controller/App.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Garden");
        primaryStage.getIcons().add(new Image("images/launcher.jpg"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void onPlantClick(ActionEvent event) {
        selectedButton = (Button) event.getSource();
        selectedButton.setDisable(true);
        garden.setSelectedPlant(selectedButton);
        update();
    }

    @FXML
    private void onAddPlantClick(ActionEvent event) {
        // TODO: Open dialog to add plant
        Plant plant = new Flower();
        garden.setSelectedPlantValue(plant);
        update();
    }

    @FXML
    private void onGiveWaterClick(ActionEvent event) {
        garden.getSelectedPlant().giveWater();
        update();
    }

    @FXML
    private void onGiveFertilizerClick(ActionEvent event) {
        garden.getSelectedPlant().giveFertilizer();
        update();
    }

    @FXML
    private void onHarvestClick(ActionEvent event) {
        garden.setSelectedPlantValue(null);
        points += 10;
        selectedButton = null;
        update();
    }

    private void update() {
        lblTotalPoints.setText(points.toString());

        // Set plant mode group
        if (selectedButton == null) {
            setPlantMode(PlantMode.UNSELECTED);
        } else {
            Plant selectedPlant = garden.getSelectedPlant();
            if (selectedPlant == null) {
                setPlantMode(PlantMode.EMPTY);

                lblPlantStage.setText("-");
                lblWaterCount.setText("-");
                lblFertilizerCount.setText("-");
            } else {
                setPlantMode(PlantMode.SELECTED);

                lblPlantStage.setText(selectedPlant.displayGrowthStatus());
                lblWaterCount.setText(selectedPlant.getWaterCount().toString());
                lblFertilizerCount.setText(selectedPlant.getFertilizerCount().toString());

                btnHarvest.setDisable(!selectedPlant.isMature());
            }
        }

        // Loops through all the buttons in the grid
        for (Node node : gridPlant.getChildren()) {
            Button btn = (Button) node;
            Plant plant = garden.getPlantInGrid(btn);

            btn.setText(plant != null ? plant.getName() : "Empty");
            btn.setDisable(btn == selectedButton);
        }
    }

    private void setPlantMode(PlantMode mode) {
        switch (mode) {
            case UNSELECTED:
                groupPlantEmpty.setDisable(true);
                groupPlantSelected.setDisable(true);
                break;
            case EMPTY:
                groupPlantEmpty.setDisable(false);
                groupPlantSelected.setDisable(true);
                break;
            case SELECTED:
                groupPlantEmpty.setDisable(true);
                groupPlantSelected.setDisable(false);
                break;

        }
    }
}
