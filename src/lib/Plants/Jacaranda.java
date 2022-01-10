package lib.Plants;

import lib.Plant;

public class Jacaranda extends Plant {
    public Jacaranda() {
        super();
        point = 170;
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 5 && fertilizerCount >= 3) {
            waterCount -= 5;
            fertilizerCount -= 3;
            growthStage++;
        }
    }
}
