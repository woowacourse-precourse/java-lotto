package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class WinningStatic {
    private HashMap<Result,Integer> resultStatic;
    private double yield;

    public WinningStatic() {
        resultStatic = new HashMap<>();
        yield = 0;
    }


    public WinningStatic compute(int purchaseMoney, List<Result> results) {
        computeCoincideCount(results);
        computeYield(purchaseMoney);
        return this;
    }

    private void computeCoincideCount(List<Result> results) {
        for (Result result : results) {
            Integer coincideCount = resultStatic.getOrDefault(result,0);
            resultStatic.put(result, coincideCount+1);
        }
    }

    private int getSumWinningAmount() {
        int sumWinningAmount=0;
        for (Entry<Result, Integer> resultEntry : resultStatic.entrySet()) {
            Result result = resultEntry.getKey();
            Integer count = resultEntry.getValue();

            sumWinningAmount += result.getPriceNum() * count;
        }
        return sumWinningAmount;
    }

    private void computeYield(int purchaseMoney) {
        int sumWinningAmount = getSumWinningAmount();
        yield= (sumWinningAmount/(double)purchaseMoney) * 100;
    }


    public HashMap<Result, Integer> getResultStatic() {
        return resultStatic;
    }

    public double getYield() {
        return yield;
    }
}
