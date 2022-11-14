package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculator {
    public int sum = 0;
    public double earningRate = 0;
    public int sumJackpot (List<Integer> winningTable){
        for (int result : winningTable) {
            if (result == 7) {
                sum += 30000000;
            } else if (result == 6) {
                sum += 2000000000;
            } else if (result == 5) {
                sum += 1500000;
            } else if (result == 4) {
                sum += 50000;
            } else if (result == 3) {
                sum += 5000;
            }
        }
        return sum;
    }
    public double calculateEarningRate(double sum, double pay){
        earningRate = Math.round(sum/pay)/10.0;
        return earningRate;
    }
}
