package lotto.model;

import java.util.EnumMap;

import static lotto.view.LottoSeller.printMessage;

public class LottoWinningAnalyzer {
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

        return Math.round(profit * 100) / 100;
    }

    private long getSumAllWinningMoney() {
        long sum = 0;

        for (WinningType type : WinningType.values()) {
            sum += type.getMoney() * winningResult.get(type);
        }

        return sum;
    }
}
