package lib.Plants;

import lib.Plant;

public class Dahlia extends Plant {
    public Dahlia() {
        super();
        point = 130;
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 5 && fertilizerCount >= 2) {
            waterCount -= 5;
            fertilizerCount -= 2;
            growthStage++;
        }
    }
}
