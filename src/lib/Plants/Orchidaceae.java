package lib.Plants;

import lib.Plant;

public class Orchidaceae extends Plant {
    public Orchidaceae() {
        super();
    }

    @Override
    protected void validateGrowth() {
        if (waterCount >= 1 && fertilizerCount >= 1) {
            waterCount -= 1;
            fertilizerCount -= 1;
            growthStage++;
        }
    }
}
