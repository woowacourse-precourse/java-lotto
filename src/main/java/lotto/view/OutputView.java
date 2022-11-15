package lotto.view;

import lotto.model.Lotto;
import lotto.model.Ranking;
import lotto.model.WinningMoney;
import lotto.util.Constants;

import java.util.List;

public class OutputView {
    public static void outputAnnounceMoney(int count) {
        System.out.println(count + Constants.PRINT_OUTPUT_MONEY);
    }

    public static void outputLottoList(List<Lotto> lottoList) {
        for (Lotto numbers : lottoList) {
            System.out.println(numbers.getNumbers());
        }
    }

    public static void outputWinningScript() {
        System.out.println(Constants.WINNING_RATE_SCRIPT);
        System.out.println(Constants.WINNING_RATE_SCRIPT_BAR);
    }

    public static void outputWinningOrder(Ranking ranking) {
        System.out.println(WinningMoney.FIFTH.print(ranking.getFifth()));
        System.out.println(WinningMoney.FOURTH.print(ranking.getFourth()));
        System.out.println(WinningMoney.THIRD.print(ranking.getThird()));
        System.out.println(WinningMoney.SECOND.print(ranking.getSecond()));
        System.out.println(WinningMoney.FIRST.print(ranking.getFirst()));
    }

    public static void outputProfitRate(String porofitRate) {
        System.out.println(Constants.PROFIT_RATE_SCRIPT_FRONT + porofitRate + Constants.PROFIT_RATE_SCRIPT_BACK);
    }
}
