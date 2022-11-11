package lotto;

public class GetRateOfReturn {
    public double calculateRate(int [] result, int money){
        int value = result[2] * 5000 + result[3] * 50000 + result[4] * 150000 + result[5] * 2000000000 + result[6] * 30000000;
        double coast = value / (double)money;
        return ((double) Math.round(coast * 1000) / 10);
    }
}
