package lib.Plants;

import lib.Plant;

public class Alternanthera extends Plant {
    public Alternanthera() {
        super();
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
