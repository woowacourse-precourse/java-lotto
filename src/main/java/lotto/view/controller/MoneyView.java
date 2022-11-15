package lotto.view.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.ScoreInfo;

import java.util.List;

import static lotto.view.controller.ConsoleMessage.*;
import static lotto.view.vlidation.InputMoneyValidator.validate;

public class MoneyView {
    private MoneyView() {
    }

    public static Integer inputMoneyNumber() {
        System.out.println(INPUT_BUY_MONEY.getMessage());
        String money = Console.readLine();
        validate(money);
        return Integer.valueOf(money);
    }

    public static void printRateOfReturn(List<Integer> scoreBoard) {
        Float totalReturn = 0F;
        Integer totalBuyMoney = scoreBoard.stream().mapToInt(Integer::intValue).sum() * 1000;
        for (ScoreInfo scoreInfo : ScoreInfo.values()) {
            totalReturn += (scoreInfo.getWinnerMoney() * scoreBoard.get(scoreInfo.getRank()));
        }
        System.out.println(PRINT_FRONT_TOTAL_RETURN_RATE.getMessage()
                + String.format("%.1f", (totalReturn / totalBuyMoney) * 100)
                + PRINT_BACK_TOTAL_RETURN_RATE.getMessage());

    }
}
