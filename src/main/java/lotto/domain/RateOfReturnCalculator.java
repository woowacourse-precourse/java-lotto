package lotto.domain;

import lotto.view.LottoView;

import java.util.Map;

public class RateOfReturnCalculator {

    private static int amount;
    private static Map<String, Integer> winning;
    private static int totalMoney;

    // 수익률을 계산
    public static void rateOfReturn() {
        double result = (double) totalMoney / (double) amount *100;
        //System.out.println(amount + " / " + totalMoney + " / " + result);
        LottoView.printRateOfReturn(result);
    }

    // 총 수익 계산
    public static double totalWinningMoney() {
        totalMoney = winning.get("3")*5000 + winning.get("4")*50000 + winning.get("5")*1500000 +
                winning.get("5+b")*30000000 + winning.get("6")*2000000000;
        return totalMoney;
    }

    public static void getAmount(int amountInt) {
        amount = amountInt;
    }

    public static void getWinningNumberMap(Map<String, Integer> winningMap) {
        winning = winningMap;
        totalWinningMoney();
    }
}
