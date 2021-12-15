public class Fruit extends Plant {
    public Fruit() {
        super();
        int index = MyUtils.generateRandomInt(0, fruitList.length);
        plantName = fruitList[index];
    }

    @Override
    public String displayGrowthStatus() {
        switch (growthStage) {
            case 1:
                return "Benih";
            case 2:
                return "Tunas";
            case 3:
                return "Tanaman Kecil";
            case 4:
                return "Tanaman Dewasa";
            case 5:
                return "Berbunga";
            case 6:
                return "Berbuah";
        }
        return "Unknown";
    }

    @Override
    protected void onGrow() {
        if (growthStage < 6) { // Changes here
            waterCount -= 3; // Same as jumlahAir = jumlahAir - 3
            fertilizerCount -= 1; // Same as jumlahPupuk = jumlahPupuk - 1
            growthStage++;
        }
    }

    @Override
    public void printStatus() {
        System.out.println(displayGrowthStatus() + " (Tahap " + getGrowthStage() + ")\n");
        if (growthStage > 5)
            System.out.println("Nama Buah       : " + getName() + "\n");
        System.out.println("Jumlah air      : " + waterCount);
        System.out.println("Jumlah pupuk    : " + fertilizerCount);
    }

    // Nama Buah
    // Link source:
    // https://id.wikipedia.org/wiki/Daftar_buah-buahan_kulinerF
    private final String[] fruitList = {
            "Anggur",
            "Apel",
            "Aprikot",
            "Alpukat",
            "Almon",
            "Ara",
            "Aren",
            "Arbei",
            "Asam",
            "Bacang",
            "Belimbing",
            "Belimbing Sayur",
            "Bengkuang",
            "Benda",
            "Beri Hitam",
            "Beri Emu",
            "Bit",
            "Binjai",
            "Bisbul",
            "Blackcurrant",
            "Blewah",
            "Bluberi",
            "Cempaka",
            "Cempedak",
            "Ceplukan",
            "Cermai",
            "Ceri",
            "Cokelat",
            "Cranberry",
            "Delima",
            "Duku",
            "Durian",
            "Duwet",
            "Erbis",
            "Frambos",
            "Feijoa",
            "Flamboyan",
            "Gandaria",
            "Gandum",
            "Gooseberry",
            "Gowok",
            "Huckleberry",
            "Jagung",
            "Jamblang",
            "Jambu",
            "Jambu Air",
            "Jambu Batu",
            "Jambu Biji",
            "Jambu Bol",
            "Jambu Mawar",
            "Jambu Mede",
            "Jambu Semarang",
            "Jengkol",
            "Jeruk",
            "Jeruk Bali",
            "Jeruk Jepara",
            "Jeruk Keprok",
            "Jeruk Kingkit",
            "Jeruk Nipis",
            "Jeruk Purut",
            "Kacang Hazel",
            "Kacang Tanah",
            "Kapulasan",
            "Kastanya",
            "Kawista",
            "Kecapi",
            "Kedondong",
            "Kelapa",
            "Kelengkeng",
            "Kenari",
            "Kepel",
            "Ketela",
            "Kemang",
            "Kersen",
            "Kesemek",
            "Kiwi",
            "Kismis",
            "Kokosan",
            "Kolang-Kaling",
            "Kopi",
            "Kurma",
            "Kates",
            "Kenitu",
            "Kuweni",
            "Lai",
            "Langsat",
            "Lemon",
            "Lengkeng",
            "Leci",
            "Limau",
            "Lobak",
            "Labu",
            "Mahkota Dewa",
            "Maja",
            "Malaka",
            "Mangga",
            "Mangga Lalijiwa",
            "Mangga Pari",
            "Manggis",
            "Markisa",
            "Matoa",
            "Melon",
            "Mengkudu",
            "Menteng",
            "Mentimun",
            "Mentimun Suri",
            "Namnam",
            "Nanas",
            "Nangka",
            "Naga",
            "Nektarin",
            "Paprika",
            "Pomelo",
            "Pepaya",
            "Persik",
            "Pinang",
            "Pir",
            "Pisang",
            "Petai",
            "Peria",
            "Plum",
            "Prune",
            "Rambai",
            "Rasberi",
            "Rambutan",
            "Rambusa",
            "Red Currant",
            "Salak",
            "Sawo",
            "Sawo Duren",
            "Sawo Kecik",
            "Sawo Manila",
            "Semangka",
            "Sirsak",
            "Siwalan",
            "Srikaya",
            "Stroberi",
            "Sukun",
            "Terap",
            "Terong",
            "Timun",
            "Tin",
            "Talok",
            "Ubi",
            "Uni",
            "Vanili",
            "Waluh",
            "Widuri",
            "Wuni",
            "Zaitun",
    };
}
