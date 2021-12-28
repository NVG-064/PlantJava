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
    private GridPane gridPlant;
    @FXML
    private Group groupPlantEmpty;
    @FXML
    private Group groupPlantSelected;

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
        Parent root = FXMLLoader.load(getClass().getResource("/layout/App.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Garden");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void onPlantClick(ActionEvent event) {
        currentButton = (Button) event.getSource();
        garden.setSelectedPlant(currentButton);
        update();
    }

    public void addPlant(ActionEvent event) {
        Plant plant = new Flower();
        garden.setSelectedPlantValue(plant);
        currentButton = null;
        update();
    }

    public void onGiveWaterClick() {
        System.out.println("onGiveWaterClick");
    }

    public void onGiveFertilizerClick() {
        System.out.println("onGiveFertilizerClick");
    }

    public void onHarvestClick() {
        System.out.println("onHarvestClick");
    }

    public void update() {
        if (currentButton == null) {
            setPlantMode(PlantMode.UNSELECTED);
        } else {
            if (garden.getSelectedPlant() == null) {
                setPlantMode(PlantMode.EMPTY);
                lblPlantName.setText("Select plant");
            } else {
                setPlantMode(PlantMode.SELECTED);
                lblPlantName.setText(garden.getSelectedPlant().getName());
            }
        }

        // Loops through all the buttons in the grid
        for (Node node : gridPlant.getChildren()) {
            Button btn = (Button) node;
            Plant plant = garden.getPlantInGrid(btn);
            if (plant != null) {
                btn.setText(plant.getName());
            }
        }
    }

    public void setPlantMode(PlantMode mode) {
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
