package lib.Plants;

import lib.Plant;

public class Gardenia extends Plant {
    public Gardenia() {
        super();
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
