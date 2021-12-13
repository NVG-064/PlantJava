public class RandomNumber {
    public int createRandomNumber(int min, int max) {
        int hasilRandom = (int)Math.floor(Math.random()*(max-min+1)+min);
        return hasilRandom;
    }
}
