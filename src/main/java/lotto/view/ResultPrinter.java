package lotto.view;

import java.util.Map;
import lotto.controller.CorrectNumber;
import lotto.controller.EarningRateCalculator;
import lotto.model.LottoStorage;

public class ResultPrinter {

    public static void printResult(Map<CorrectNumber, Long> resultMap) {
        for(CorrectNumber correctNumber : CorrectNumber.values()) {
            Long value = resultMap.get(correctNumber);
            if (value == null) {
                value = 0L;
            }
            System.out.println(correctNumber.getPrizeInformationMent() + value + "개");
        }

        System.out.println("총 수익률은 " +
                EarningRateCalculator.calculateEarningRate() +
                "%입니다.");
    }
}
