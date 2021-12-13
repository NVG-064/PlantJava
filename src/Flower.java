public class Flower extends Plant {
    private int hasilRandom; // Put after creating random number here

    // Override existing method
    @Override
    public void displayPlant() {
        System.out.println(getStatusTumbuhText()); // Changes here
        if (statusTumbuh == 4) System.out.println("Nama Bunga      : " + getNamaBungaText() + "\n"); // Changes here
        System.out.println("\nJumlah air      : " + jumlahAir);
        System.out.println("Jumlah pupuk    : " + jumlahPupuk);
    }

    // Reset statistic
    public void resetTanam() {
        statusTumbuh = 0;
        jumlahPupuk = 0;
        jumlahAir = 0;
        RandomNumber rn = new RandomNumber();
        hasilRandom = rn.createRandomNumber(0, 72); // Run create random number, with Minimun 0 and Maximum 149 (equals to 1 to 150)
        System.out.print("\033[H\033[2J"); // Clear screen
        System.out.print("Tanaman ditebang dan benih baru ditanam");
    }

    // Print Nama Bunga
    // Link source:
    // https://id.wikipedia.org/wiki/Kategori:Bunga
    public String getNamaBungaText() {
        switch (hasilRandom+1) {
            case 1: return "Ajang Kelicung";
            case 2: return "Alternanthera";
            case 3: return "Amarilis";
            case 4: return "Anggrek Jamrud";
            case 5: return "Anggrek Larat";
            case 6: return "Anggrek Mutiara";
            case 7: return "Anggrek Serat";
            case 8: return "Anyelir";
            case 9: return "Aster";
            case 10: return "Azalea";
            case 11: return "Bakung Lelabah Merah";
            case 12: return "Bauhinia Coccinea";
            case 13: return "Bellis Perennis";
            case 14: return "Botan";
            case 15: return "Bunga Air Mancur";
            case 16: return "Bunga Kuku Macan";
            case 17: return "Bunga Pukul Empat";
            case 18: return "Bunga Tasbih";
            case 19: return "Campsis Grandiflora";
            case 20: return "Cempaka Hutan Kasar";
            case 21: return "Crinum";
            case 22: return "Crocus";
            case 23: return "Dahlia";
            case 24: return "Datura";
            case 25: return "Daun Gedi";
            case 26: return "Episcia";
            case 27: return "Episcia Cupreata";
            case 28: return "Euphorbia";
            case 29: return "Flamboyan";
            case 30: return "Gaillardia";
            case 31: return "Gardenia";
            case 32: return "Geranium";
            case 33: return "Helianthus";
            case 34: return "Herbras";
            case 35: return "Hortensia";
            case 36: return "Hymenocallis";
            case 37: return "Ipomoea Obscura";
            case 38: return "Jacaranda";
            case 39: return "Kacapiring";
            case 40: return "Kaliko";
            case 41: return "Kenanga";
            case 42: return "Kenikir Sulfur";
            case 43: return "Kimilsungia";
            case 44: return "Kuma-kuma";
            case 45: return "Lavender";
            case 46: return "Lili Hujan";
            case 47: return "Lobelia Deckenii";
            case 48: return "Mawar";
            case 49: return "Mawar Biru";
            case 50: return "Melati";
            case 51: return "Narsis";
            case 52: return "Oenothera";
            case 53: return "Oshibana";
            case 54: return "Pacar Iir";
            case 55: return "Petunia";
            case 56: return "Piretrum";
            case 57: return "Primula";
            case 58: return "Rafflesia";
            case 59: return "Randa Tapak";
            case 60: return "Rombusa";
            case 61: return "Rosela";
            case 62: return "Sakura";
            case 63: return "Seroja";
            case 64: return "Serunai";
            case 65: return "Soka jawa";
            case 66: return "Teratai";
            case 67: return "Tulip";
            case 68: return "Wrightia";
            case 69: return "Wrightia Antidysenterica";
            case 70: return "Xerochrysum Bracteatum";
            case 71: return "Yareta";
            case 72: return "Zinia";
            case 73: return "Zodia";
        }

        return "Tidak ada nama bunga yang terdefinisi";
    }

    // Create random number
    // public void createRandomNumber(int min, int max) {
    //     this.hasilRandom = (int)Math.floor(Math.random()*(max-min+1)+min);
    // }

    // Constructor
    public Flower() {
        super();
        RandomNumber rn = new RandomNumber();
        hasilRandom = rn.createRandomNumber(0, 72);
    }
}
