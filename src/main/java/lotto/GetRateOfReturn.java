package lotto;

public class GetRateOfReturn {
    public String calculateRate(long [] result, long money){
        long value = result[3] * 5000 + result[4] * 50000 + result[5] * 150000 + result[6] * 2000000000 + result[7] * 30000000;
        double yield = ((double) value / money) * 100;
        return String.format("%.1f", yield);

    }
}
