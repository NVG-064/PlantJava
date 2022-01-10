package lib.Plants;

import lib.Plant;

public class Crinum extends Plant {
    public Crinum() {
        super();
        point = 70;
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 4 && fertilizerCount >= 1) {
            waterCount -= 4;
            fertilizerCount -= 1;
            growthStage++;
        }
    }
}
