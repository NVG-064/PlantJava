import java.util.ArrayList;

public class Garden {
    private int SIZE = 10;
    private int nTanaman = 0;
    private String mGardenName;
    private ArrayList<Plant> plantList;
    private int hasilPanen;
    private int flags;
    
    
    public Garden(String pName) {
        plantList = new ArrayList<Plant>();
        mGardenName = pName;
    }

    public Garden() {
        this("MiGarden"); // Change UGarden to MiGarden
    }

    public boolean addPlant(Plant p, int flags) {
        if(nTanaman < SIZE) {
            plantList.add(p);
            nTanaman++;
            this.flags = flags;
            return true;
        } else
            return false;
    }

    public int harvestPlant() {
        int tmpN=0;
        int i=0;
        
        while ((plantList != null) && (i < plantList.size())) {
            if(plantList.get(i).getGrowthStatus() == 4) {
                plantList.remove(i);
                nTanaman--;
                tmpN++;
                i=0;
            } else
                i++;
        }
        
        hasilPanen = hasilPanen + (tmpN*100);
        return tmpN;
    }

    public void beriAir() {
        for (int i = 0; i < plantList.size(); i++) {
            plantList.get(i).giveWater();
        }
    }

    public void beriPupuk() {
        for (int i = 0; i < plantList.size(); i++) {
            plantList.get(i).giveFertilizer();
        }
    }

    public void displayPlant() {
        System.out.println("\t\t" + mGardenName + "\n\n");
        System.out.println("There are " + nTanaman + " plant(s) in the garden");
        System.out.println("Your harvest point: " + hasilPanen);
        
        for (int i = 0; i < plantList.size(); i++) {
            if (i != plantList.size())
                System.out.println("\n=======================================================\n");
            plantList.get(i).displayPlant(flags);
            if ((i == plantList.size()) || (i == plantList.size()-1))
                System.out.println("\n=======================================================\n");
        }
    }

    public int getHasilPanen() {
        return hasilPanen;
    }
}
