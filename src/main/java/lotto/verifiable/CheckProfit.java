package lotto.verifiable;

import lotto.Profit;
import lotto.validate.Validator;

import java.util.*;

public class CheckProfit implements Verifiable<Profit>{
    public static void printBenefit(Map<PrizeMoney, Integer> gradeIntegerMap, Integer prizeAmount) {
        double earningRatio = calcBenefit(gradeIntegerMap, prizeAmount);
        System.out.println("총 수익률은 " + earningRatio + "%입니다.");
    }

    private static double calcBenefit(Map<PrizeMoney, Integer> gradeIntegerMap, Integer prizeAmount){
        Iterator<PrizeMoney> iter = gradeIntegerMap.keySet().iterator();

        Long total = 0L;
        while(iter.hasNext()) {
            PrizeMoney next = iter.next();

            Long prizeMoney = next.getValue();
            Integer prizeCount = gradeIntegerMap.get(next);

            total += prizeCount * prizeMoney;
        }
        return Validator.validateDividedByZero(total, prizeAmount);
    }


    @Override
    public Integer checkWithValue(Profit input) {
        return null;
    }
}