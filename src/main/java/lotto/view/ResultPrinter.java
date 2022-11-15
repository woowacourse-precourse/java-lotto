package lotto.view;

import lotto.controller.CorrectNumber;
import lotto.controller.EarningRateCalculator;
import lotto.model.LottoStorage;

public class ResultPrinter {

    public static void printResult() {
        for(CorrectNumber correctNumber : CorrectNumber.values()) {
            System.out.println(correctNumber.getPrizeInformationMent() + "개");
        }

        System.out.println("총 수익률은 " +
                EarningRateCalculator.calculateEarningRate(LottoStorage.getInputMoney()) +
                "%입니다.");
    }
}
