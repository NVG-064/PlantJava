package lib.Plants;

import lib.Plant;

public class Hydrangea extends Plant {
    public Hydrangea() {
        super();
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 2 && fertilizerCount >= 1) {
            waterCount -= 2;
            fertilizerCount -= 1;
            growthStage++;
        }
    }
}
