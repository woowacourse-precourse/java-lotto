package lotto;

public class GetRateOfReturn {
    public double calculateRate(long [] result, long money){
        long value = result[2] * 5000 + result[3] * 50000 + result[5] * 150000 + result[6] * 2000000000 + result[7] * 30000000;
        double coast = value / (double)money;
        return ((double) Math.round(coast * 1000) / 10);
    }
}
