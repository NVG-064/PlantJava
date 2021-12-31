package lib.Plants;

import lib.Plant;

public class Dahlia extends Plant {
    public Dahlia() {
        super();
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
