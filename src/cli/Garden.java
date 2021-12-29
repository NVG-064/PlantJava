package cli;

import java.util.ArrayList;

import utils.MyUtils;

@Deprecated
public class Garden {
    private String gardenName;
    private ArrayList<Plant> plantList;
    private int harvestPoint;

    public Garden(String name) {
        plantList = new ArrayList<Plant>();
        gardenName = name;
    }

    public int getHarvestPoint() {
        return harvestPoint;
    }

    public void addPlant() {
        int num = MyUtils.generateRandomInt(0, 1);
        Plant plant;
        if (num == 0) {
            plant = new Fruit();
        } else {
            plant = new Flower();
        }
        plantList.add(plant);
    }

    public void addPlant(Plant p) {
        plantList.add(p);
    }

    public void harvestPlant() {
        int harvestCount = 0;

        for (int i = plantList.size()-1; i >= 0; --i) {
            if (plantList.get(i).getGrowthStage() > 4) {
                harvestCount++;
                plantList.remove(i);
            }
        }

        harvestPoint += harvestCount * 100;
    }

    public void waterPlants() {
        for (Plant plant : plantList) {
            plant.giveWater();
        }
    }

    public void fertilizePlants() {
        for (Plant plant : plantList) {
            plant.giveFertilizer();
        }
    }

    public void displayPlants() {
        System.out.println("\t\t" + gardenName + "\n\n");
        System.out.println("Ada " + plantList.size() + " tanaman di kebun");
        System.out.println("Poin hasil panen kamu: " + harvestPoint);

        for (int i = 0; i < plantList.size(); i++) {
            if (i != plantList.size())
                System.out.println("\n=======================================================\n");
            plantList.get(i).printStatus();
            if (i == plantList.size() - 1)
                System.out.println("\n=======================================================\n");
        }
    }
}
