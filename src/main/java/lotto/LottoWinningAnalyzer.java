package lotto;

import java.util.EnumMap;

import static lotto.LottoConstant.*;

public class LottoWinningAnalyzer {
    private EnumMap<WinningType, Integer> winningResult;

    public LottoWinningAnalyzer(EnumMap<WinningType, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public void printWinningResult() {
        winningResult.forEach((key, value) -> {
            System.out.println(String.format(key.getMessage(), value));
        });
    }

    public void printProfit(int userMoney) {
        System.out.println(String.format(WINNING_RESULT_MSG, calculateProfit(userMoney)));
    }

    private double calculateProfit(int userMoney) {
        double winningMoney = getSumAllWinningMoney();
        double profit = winningMoney / userMoney * 100;
        double roundDecimalPoint = Math.pow(10, ROUND_POINT);

        return Math.round(profit * roundDecimalPoint) / roundDecimalPoint;
    }

    private long getSumAllWinningMoney() {
        long sum = 0;

        for (WinningType type : WinningType.values()) {
            sum += type.getMoney() * winningResult.get(type).intValue();
        }

        return sum;
    }
}
