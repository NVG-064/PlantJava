package lib.Plants;

import lib.Plant;

public class Gerbera extends Plant {
    public Gerbera() {
        super();
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 3 && fertilizerCount >= 2) {
            waterCount -= 3;
            fertilizerCount -= 2;
            growthStage++;
        }
    }
}
