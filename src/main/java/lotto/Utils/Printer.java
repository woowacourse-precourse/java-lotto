package lotto.Utils;

import lotto.Domain.LottoShop;
import lotto.Domain.Statistic;

import java.util.List;

import static lotto.Enum.InformationMessage.*;
import static lotto.Enum.LottoProperty.HIGHEST_WINNING_RANK;
import static lotto.Enum.LottoProperty.LOWEST_WINNING_RANK;
import static lotto.Enum.StatisticMessage.STATISTIC;
import static lotto.Enum.StatisticMessage.*;

public class Printer {
    public void inputMoney() {
        System.out.println(INPUT_AMOUNT_OF_MONEY_TO_BUY.getMessage());
    }

    public void inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
    }

    public void inputBonusNumber() {
        System.out.println(INPUT_BONUS_WINNING_NUMBER.getMessage());
    }

    public void lottoCount(int count) {
        System.out.println(count + COUNT_OF_LOTTO.getMessage());
    }

    public void statistic() {
        Statistic statistic = new Statistic();

        System.out.println(STATISTIC.getMessage());
        statistic.analyze();

        List<String> rankMessageList = List.of(
                null,
                WINNING_1RANK.getMessage(),
                WINNING_2RANK.getMessage(),
                WINNING_3RANK.getMessage(),
                WINNING_4RANK.getMessage(),
                WINNING_5RANK.getMessage()
        );
        String suffix = SUFFIX.getMessage();

        for (int rank = LOWEST_WINNING_RANK.getValue(); rank > HIGHEST_WINNING_RANK.getValue(); rank--) {
            String message = rankMessageList.get(rank);
            int count = statistic.getRankCount(rank);

            System.out.println(message + count + suffix);
        }

        totalYield(statistic.accumulatedWinningMoney);
    }

    public void totalYield(long winningMoney) {
        int money = LottoShop.money;

        // TODO: 구매했던 금액과 누적상금으로 수익률 계산

        double yield = 0;

        String message = TOTAL_YIELD.getMessage();
        System.out.printf(message, yield);
    }

}
