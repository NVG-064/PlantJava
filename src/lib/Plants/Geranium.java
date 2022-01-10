package lib.Plants;

import lib.Plant;

public class Geranium extends Plant {
    public Geranium() {
        super();
        point = 70;
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 2 && fertilizerCount >= 2) {
            waterCount -= 2;
            fertilizerCount -= 2;
            growthStage++;
        }
    }
}
