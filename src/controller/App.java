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
    private Label lblPlantName;
    @FXML
    private Label lblPointValue;
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
    private Button currentButton;

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
        currentButton = (Button) event.getSource();
        currentButton.setDisable(true);
        garden.setSelectedPlant(currentButton);
        update();
    }

    @FXML
    private void onAddPlantClick(ActionEvent event) {
        Plant plant = new Flower();
        garden.setSelectedPlantValue(plant);
        currentButton = null;
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
        // Harvest method
        update();
    }

    private void update() {
        // Set plant mode group
        if (currentButton == null) {
            setPlantMode(PlantMode.UNSELECTED);
        } else {
            if (garden.getSelectedPlant() == null) {
                setPlantMode(PlantMode.EMPTY);
                lblPlantName.setText("Select Plant");
            } else {
                setPlantMode(PlantMode.SELECTED);
                lblPlantName.setText(garden.getSelectedPlant().displayGrowthStatus());
                btnHarvest.setDisable(true);
                if (garden.getSelectedPlant().getGrowthStage() > 4) {
                    btnHarvest.setDisable(false);
                }
            }
        }

        // Loops through all the buttons in the grid
        for (Node node : gridPlant.getChildren()) {
            Button btn = (Button) node;
            Plant plant = garden.getPlantInGrid(btn);

            btn.setText(plant != null ? plant.getName() : "Empty");
            btn.setDisable(btn == currentButton);
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
