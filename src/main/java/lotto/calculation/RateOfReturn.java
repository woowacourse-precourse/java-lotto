package lotto.calculation;

import java.util.Map;

public class RateOfReturn {
    public static double calculate(Map<String, Integer> statistics, int amount) {
        double rateOfReturn = 0;
        double revenue = 0;
        for (int rank = 1; rank < 6; rank++) {
            if (rank == 1) {revenue += (statistics.get(rank+"등") * 2000000000);}
            if (rank == 2) {revenue += (statistics.get(rank+"등") * 30000000);}
            if (rank == 3) {revenue += (statistics.get(rank+"등") * 1500000);}
            if (rank == 4) {revenue += (statistics.get(rank+"등") * 50000);}
            if (rank == 5) {revenue += (statistics.get(rank+"등") * 5000);}
        }//for
        rateOfReturn = Math.round((revenue / amount * 100) * 10.0) / 10.0;
        return (double) rateOfReturn;
    }//calculate
} //end class
