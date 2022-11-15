package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Result;

public class OutputView {
    private static final OutputView instance = new OutputView();
    private static final List<Rank> printOrder = Arrays.stream(Rank.values())
            .filter(rank -> rank != Rank.EMPTY)
            .sorted(Comparator.comparingInt(Rank::prise))
            .collect(Collectors.toList());

    private OutputView() {
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.printf((OutputMessage.PURCHASE.message()), lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
        }
    }

    public void printStatistics(Result result) {
        System.out.println(OutputMessage.STATISTICS.message());
        printRank(result);
        printRateOfReturn(result);
    }

    private void printRank(Result result) {
        for (Rank rank : printOrder) {
            String format = OutputMessage.RESULT.message();
            if (rank.bonus()) {
                format = OutputMessage.RESULT_BONUS.message();
            }
            System.out.printf(format, rank.common(), rank.prise(), result.getRankResult(rank));
        }
    }

    private void printRateOfReturn(Result result) {
        System.out.printf(OutputMessage.RESULT_ROT.message(), result.getRateOfReturn());
    }

    public static OutputView getInstance() {
        return instance;
    }
}
