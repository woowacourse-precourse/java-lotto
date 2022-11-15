package lotto.IO;

import lotto.data.OutputConstants;
import lotto.data.Rank;
import lotto.domain.Lotto;
import lotto.domain.StartLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.TotalResult.calculate;
import static lotto.domain.TotalResult.getCount;


public class Output {

    public static void printLotto() {
        System.out.println(Lotto.lottoQuantity + OutputConstants.boughtOutput);
        for (Lotto e : StartLotto.lotto)
            printNumbers(e);
    }

    public static void printNumbers(Lotto lotto) {
        List<Integer> numberForPrint = new ArrayList<>();
        for (int e : lotto.getNums())
            Collections.addAll(numberForPrint, e);
        Collections.sort(numberForPrint);
        System.out.println(numberForPrint);
    }

    public static void requestWinNum() {
        System.out.println(OutputConstants.inputWinNumOutput);
    }

    public static void requestBonusInput() {
        System.out.println(OutputConstants.inputBonusNumOutput);
    }

    public static void printResult() {
        System.out.println(OutputConstants.winResultOutput);
        System.out.println(OutputConstants.linebreakOutput);
        for (Rank e : Rank.values())
            printRank(e);
        System.out.println(OutputConstants.totalRevenueOutput1 + calculate() + OutputConstants.totalRevenueOutput2);
    }

    public static void printRank(Rank e) {
        System.out.println(e.getCondition() + " (" + e.getPrizeString() + ") - " + getCount(e.getRank()) + "개");
    }
}
