package lib.Plants;

import lib.Plant;

public class Peony extends Plant {
    public Peony() {
        super();
        point = 90;
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
