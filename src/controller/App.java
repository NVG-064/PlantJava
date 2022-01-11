package controller;

import java.time.LocalDateTime;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
    private Button btnExit;
    @FXML
    private Button btnHarvest;
    @FXML
    private ComboBox<String> cBoxPlant;
    @FXML
    private Pane mainPane;
    @FXML
    private Label lblGreetings;
    @FXML
    private Label lblGoodText;
    @FXML
    private ImageView ivGreetings;
    @FXML
    private Label lblWelcome;
    @FXML
    private Pane aboutPane;
    @FXML
    private Pane aboutPane2;
    @FXML
    private Pane homePane;
    @FXML
    private Pane homePane2;

    // Field declaration
    enum PlantMode {
        UNSELECTED,
        EMPTY,
        SELECTED,
    }

    private Garden garden = new Garden();
    private Button selectedButton;
    private Integer points = 0;

    private final String plantNames[] = {
            "Amaryllis",
            "Aster",
            "Azalea",
            "Canna",
            "Crinum",
            "Crocus",
            "Dahlia",
            "Datura",
            "Episcia",
            "Euphorbia",
            "Gaillardia",
            "Gardenia",
            "Geranium",
            "Gerbera",
            "Helianthus",
            "Hydrangea",
            "Hymenocallis",
            "Jacaranda",
            "Kimilsungia",
            "Orchidaceae",
            "Peony",
            "Rose",
            "Sunflower"
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/controller/App.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Garden");
        primaryStage.getIcons().add(new Image("images/launcher.png"));
        primaryStage.setResizable(false);
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
    private void onAddPlantClick(ActionEvent event) throws Exception {
        String plantName = cBoxPlant.getValue();
        if (plantName == null)
            return;
        Plant plant = (Plant) Class.forName("lib.Plants." + plantName).getDeclaredConstructor().newInstance();
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
        points += garden.getSelectedPlant().getBonus();
        garden.setSelectedPlantValue(null);
        selectedButton = null;
        update();
    }

    @FXML
    private void onExitClick(ActionEvent event) {
        Stage stage;

        stage = (Stage) mainPane.getScene().getWindow();
        stage.close();
    }

    /*
     * This things disabled due to bugs
     * on switching scenes
     * 
    @FXML
    private void onAboutClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/controller/About.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onHomeClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/controller/App.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    */

    @FXML
    private void onAboutClick(ActionEvent e) {
        homePane.setVisible(false);
        homePane2.setVisible(false);
        aboutPane.setVisible(true);
        aboutPane2.setVisible(true);
    }

    @FXML
    private void onHomeClick(ActionEvent e) {
        homePane.setVisible(true);
        homePane2.setVisible(true);
        aboutPane.setVisible(false);
        aboutPane2.setVisible(false);
    }

    private void update() {
        cBoxPlant.setItems(FXCollections.observableArrayList(plantNames));

        lblTotalPoints.setText(points.toString());
        lblPlantStage.setText("-");
        lblWaterCount.setText("-");
        lblFertilizerCount.setText("-");

        // Loops through all the buttons in the grid
        for (Node node : gridPlant.getChildren()) {
            Button btn = (Button) node;
            Plant plant = garden.getPlantInGrid(btn);

            btn.setText(plant != null ? plant.getName() : "Empty");
            btn.setDisable(btn == selectedButton);
        }

        // Set plant mode group
        if (selectedButton == null) {
            setPlantMode(PlantMode.UNSELECTED);
            return;
        }

        Plant selectedPlant = garden.getSelectedPlant();
        if (selectedPlant == null) {
            setPlantMode(PlantMode.EMPTY);
            return;
        }

        setPlantMode(PlantMode.SELECTED);
        lblPlantStage.setText(selectedPlant.getGrowthStage());
        lblWaterCount.setText(selectedPlant.getWaterCount().toString());
        lblFertilizerCount.setText(selectedPlant.getFertilizerCount().toString());

        if (selectedPlant.isMature()) {
            setPlantMode(PlantMode.UNSELECTED);
            btnHarvest.setDisable(false);
        }

        getTimeAndSetGreetings();
    }

    private void setPlantMode(PlantMode mode) {
        switch (mode) {
            case UNSELECTED:
                groupPlantEmpty.setDisable(true);
                groupPlantSelected.setDisable(true);
                btnHarvest.setDisable(true);
                break;
            case EMPTY:
                groupPlantEmpty.setDisable(false);
                groupPlantSelected.setDisable(true);
                btnHarvest.setDisable(true);
                break;
            case SELECTED:
                groupPlantEmpty.setDisable(true);
                groupPlantSelected.setDisable(false);
                btnHarvest.setDisable(true);
                break;

        }
    }

    private void getTimeAndSetGreetings() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        setGreeting(hour, minute);
    }

    private void setGreeting(int hour, int minute) {
        lblWelcome.setVisible(false);
        lblGoodText.setVisible(true);
        lblGreetings.setVisible(true);
        if ((hour >= 18 && hour <= 23) && (minute >= 0 && minute <= 59)) {
            lblGreetings.setText("Night");
            Image nightImage = new Image("controller/drawables/night.png");
            ivGreetings.setImage(nightImage);
        }
        else if ((hour >= 0 && hour <= 11) && (minute >= 0 && minute <= 59)) {
            lblGreetings.setText("Morning");
            Image morningImage = new Image("controller/drawables/morning.png");
            ivGreetings.setImage(morningImage);
        }
        else if ((hour >= 12 && hour <= 14) && (minute >= 0 && minute <= 59)) {
            lblGreetings.setText("Afternoon");
            Image afternoonImage = new Image("controller/drawables/afternoon.png");
            ivGreetings.setImage(afternoonImage);
        }
        else if ((hour >= 15 && hour <= 17) && (minute >= 0 && minute <= 59)) {
            lblGreetings.setText("Evening");
            Image eveningImage = new Image("controller/drawables/evening.png");
            ivGreetings.setImage(eveningImage);
        }
    }
}
