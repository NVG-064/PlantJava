package lib.Plants;

import lib.Plant;

public class Amaryllis extends Plant {
    public Amaryllis() {
        super();
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 3 && fertilizerCount >= 2) {
            waterCount -= 2;
            fertilizerCount -= 2;
            growthStage++;
        }
    }
}
