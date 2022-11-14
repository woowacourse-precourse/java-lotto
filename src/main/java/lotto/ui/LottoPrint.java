package lotto.ui;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.lotto.Lotto;
import lotto.rank.Rank;

public class LottoPrint {
    DecimalFormat df = new DecimalFormat("###,###");

    public void buyLottoPrice() {
        System.out.println(Message.BUY_LOTTO_PRICE);
    }

    public void prizeNumber() {
        System.out.println(Message.REQUEST_PRIZE_NUMBERS);
    }

    public void bonusNumber() {
        System.out.println(Message.REQUEST_BONUS_NUMBER);
    }

    public void buyLotto(int count) {
        System.out.println(count + Message.BUY_LOTTO_COUNT);
    }

    public void buyLottoNumbers(List<Lotto> buyNumbers) {
        for (Lotto lotto : buyNumbers) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void stats(Map<Rank, Integer> prize) {
        System.out.println(Message.LOTTO_STATS);
        System.out.println(Message.CENTER_LINE);
        for (Rank rank : Rank.values()) {
            long winProfit = rank.getWinProfit();
            String converterProfit = df.format(winProfit);
            printPrizeDetails(prize, rank, converterProfit);
        }
    }

    private void printPrizeDetails(Map<Rank, Integer> prize, Rank rank, String converterProfit) {
        if (rank.getNumber() == 6 && rank.getBonusYN()) {
            System.out.printf(Message.PRIZE_DETAILS_SECOND_PLACE, rank.getNumber() - 1, converterProfit, prize.get(rank));
            return;
        }
        System.out.printf(Message.PRIZE_DETAILS, rank.getNumber(), converterProfit, prize.get(rank));
    }

    public void rate(double amount) {
        System.out.printf(Message.TOTAL_RATE, amount);
    }

}
