package lib.Plants;

import lib.Plant;

public class Canna extends Plant {
    public Canna() {
        super();
        point = 190;
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 6 && fertilizerCount >= 3) {
            waterCount -= 6;
            fertilizerCount -= 3;
            growthStage++;
        }
    }
}
