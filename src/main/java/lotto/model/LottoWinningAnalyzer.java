package lotto.model;

import lotto.resource.MessageType;
import lotto.resource.WinningType;

import java.util.EnumMap;

import static lotto.view.LottoSeller.printMessage;

public class LottoWinningAnalyzer {
    private static final int DECIMAL_POINT = 2;

    private EnumMap<WinningType, Integer> winningResult;

    public LottoWinningAnalyzer(EnumMap<WinningType, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public void printWinningResult() {
        winningResult.forEach((key, value) -> {
            printMessage(String.format(key.getMessage(), value));
        });
    }

    public void printProfit(int userMoney) {
        printMessage(String.format(
                MessageType.WINNING_RESULT.getMessage(), calculateProfit(userMoney)));
    }

    private double calculateProfit(int userMoney) {
        double winningMoney = getSumAllWinningMoney();
        double profit = winningMoney / userMoney * 100;
        double roundDecimalPoint = Math.pow(10, DECIMAL_POINT);

        return Math.round(profit * roundDecimalPoint) / roundDecimalPoint;
    }

    private long getSumAllWinningMoney() {
        long sum = 0;

        for (WinningType type : WinningType.values()) {
            sum += type.getMoney() * winningResult.get(type);
        }

        return sum;
    }
}
