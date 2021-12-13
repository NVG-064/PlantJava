class Fruit extends Plant { // Inherit Plant as Parent to Fruit as Child
    private int hasilRandom; // Put after creating random number here

    // Override existing method
    @Override
    public String getStatusTumbuhText() {
        switch(statusTumbuh) {
            case 0: return "Benih"; // 0
            case 1: return "Tunas"; // 1
            case 2: return "Tanaman Kecil"; // 2
            case 3: return "Tanaman Dewasa"; // 3
            case 4: return "Berbunga"; // 4, changes here
        }

        return "Berbuah"; // 5, changes here
    }

    // Override existing method
    @Override
    public void tumbuh() {
        if (statusTumbuh < 5) { // Changes here
            jumlahAir -= 3; // Same as jumlahAir = jumlahAir - 3
            jumlahPupuk -= 1; // Same as jumlahPupuk = jumlahPupuk - 1
            statusTumbuh++;
        }
    }

    // Override existing method
    @Override
    public void displayPlant() {
        System.out.println(getStatusTumbuhText()); // Changes here
        if (statusTumbuh == 5) System.out.println("Nama Buah       : " + getNamaBuahText() + "\n"); // Changes here
        System.out.println("\nJumlah air      : " + jumlahAir);
        System.out.println("Jumlah pupuk    : " + jumlahPupuk);
    }

    // Reset statistic
    public void resetTanam() {
        statusTumbuh = 0;
        jumlahPupuk = 0;
        jumlahAir = 0;
        RandomNumber rn = new RandomNumber();
        hasilRandom = rn.createRandomNumber(0, 149); // Run create random number, with Minimun 0 and Maximum 149 (equals to 1 to 150)
        System.out.print("\033[H\033[2J"); // Clear screen
        System.out.print("Tanaman ditebang dan benih baru ditanam");
    }

    // Print Nama Buah
    // Link source:
    // https://id.wikipedia.org/wiki/Daftar_buah-buahan_kuliner
    public String getNamaBuahText() {
        switch (hasilRandom+1) {
            case 1: return "Anggur";
            case 2: return "Apel";
            case 3: return "Aprikot";
            case 4: return "Alpukat";
            case 5: return "Almon";
            case 6: return "Ara";
            case 7: return "Aren";
            case 8: return "Arbei";
            case 9: return "Asam";
            case 10: return "Bacang";
            case 11: return "Belimbing";
            case 12: return "Belimbing Sayur";
            case 13: return "Bengkuang";
            case 14: return "Benda";
            case 15: return "Beri Hitam";
            case 16: return "Beri Emu";
            case 17: return "Bit";
            case 18: return "Binjai";
            case 19: return "Bisbul";
            case 20: return "Blackcurrant";
            case 21: return "Blewah";
            case 22: return "Bluberi";
            case 23: return "Cempaka";
            case 24: return "Cempedak";
            case 25: return "Ceplukan";
            case 26: return "Cermai";
            case 27: return "Ceri";
            case 28: return "Cokelat";
            case 29: return "Cranberry";
            case 30: return "Delima";
            case 31: return "Duku";
            case 32: return "Durian";
            case 33: return "Duwet";
            case 34: return "Erbis";
            case 35: return "Frambos";
            case 36: return "Feijoa";
            case 37: return "Flamboyan";
            case 38: return "Gandaria";
            case 39: return "Gandum";
            case 40: return "Gooseberry";
            case 41: return "Gowok";
            case 42: return "Huckleberry";
            case 43: return "Jagung";
            case 44: return "Jamblang";
            case 45: return "Jambu";
            case 46: return "Jambu Air";
            case 47: return "Jambu Batu";
            case 48: return "Jambu Biji";
            case 49: return "Jambu Bol";
            case 50: return "Jambu Mawar";
            case 51: return "Jambu Mede";
            case 52: return "Jambu Semarang";
            case 53: return "Jengkol";
            case 54: return "Jeruk";
            case 55: return "Jeruk Bali";
            case 56: return "Jeruk Jepara";
            case 57: return "Jeruk Keprok";
            case 58: return "Jeruk Kingkit";
            case 59: return "Jeruk Nipis";
            case 60: return "Jeruk Purut";
            case 61: return "Kacang Hazel";
            case 62: return "Kacang Tanah";
            case 63: return "Kapulasan";
            case 64: return "Kastanya";
            case 65: return "Kawista";
            case 66: return "Kecapi";
            case 67: return "Kedondong";
            case 68: return "Kelapa";
            case 69: return "Kelengkeng";
            case 70: return "Kenari";
            case 71: return "Kepel";
            case 72: return "Ketela";
            case 73: return "Kemang";
            case 74: return "Kersen";
            case 75: return "Kesemek";
            case 76: return "Kiwi";
            case 77: return "Kismis";
            case 78: return "Kokosan";
            case 79: return "Kolang-Kaling";
            case 80: return "Kopi";
            case 81: return "Kurma";
            case 82: return "Kates";
            case 83: return "Kenitu";
            case 84: return "Kuweni";
            case 85: return "Lai";
            case 86: return "Langsat";
            case 87: return "Lemon";
            case 88: return "Lengkeng";
            case 89: return "Leci";
            case 90: return "Limau";
            case 91: return "Lobak";
            case 92: return "Labu";
            case 93: return "Mahkota Dewa";
            case 94: return "Maja";
            case 95: return "Malaka";
            case 96: return "Mangga";
            case 97: return "Mangga Lalijiwa";
            case 98: return "Mangga Pari";
            case 99: return "Manggis";
            case 100: return "Markisa";
            case 101: return "Matoa";
            case 102: return "Melon";
            case 103: return "Mengkudu";
            case 104: return "Menteng";
            case 105: return "Mentimun";
            case 106: return "Mentimun Suri";
            case 107: return "Namnam";
            case 108: return "Nanas";
            case 109: return "Nangka";
            case 110: return "Naga";
            case 111: return "Nektarin";
            case 112: return "Paprika";
            case 113: return "Pomelo";
            case 114: return "Pepaya";
            case 115: return "Persik";
            case 116: return "Pinang";
            case 117: return "Pir";
            case 118: return "Pisang";
            case 119: return "Petai";
            case 120: return "Peria";
            case 121: return "Plum";
            case 122: return "Prune";
            case 123: return "Rambai";
            case 124: return "Rasberi";
            case 125: return "Rambutan";
            case 126: return "Rambusa";
            case 127: return "Red Currant";
            case 128: return "Salak";
            case 129: return "Sawo";
            case 130: return "Sawo Duren";
            case 131: return "Sawo Kecik";
            case 132: return "Sawo Manila";
            case 133: return "Semangka";
            case 134: return "Sirsak";
            case 135: return "Siwalan";
            case 136: return "Srikaya";
            case 137: return "Stroberi";
            case 138: return "Sukun";
            case 139: return "Terap";
            case 140: return "Terong";
            case 141: return "Timun";
            case 142: return "Tin";
            case 143: return "Talok";
            case 144: return "Ubi";
            case 145: return "Uni";
            case 146: return "Vanili";
            case 147: return "Waluh";
            case 148: return "Widuri";
            case 149: return "Wuni";
            case 150: return "Zaitun";
        }

        return "Tidak ada nama buah yang terdefinisi";
    }

    // Create random number
    // public void createRandomNumber(int min, int max) {
    //     this.hasilRandom = (int)Math.floor(Math.random()*(max-min+1)+min);
    // }

    // Constructor
    public Fruit() {
        super();
        RandomNumber rn = new RandomNumber();
        hasilRandom = rn.createRandomNumber(0, 149);
    }
}
