package view;

import domain.Lotto;
import util.LottoMessage;
import util.LottoRank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static util.LottoMessage.SAMES_FORMAT;
import static util.LottoMessage.OPEN_BRACKET;
import static util.LottoMessage.CLOSE_BRACKET;
import static util.LottoMessage.HYPHEN_WITH_SPACE;
import static util.LottoMessage.KOREA_BASICS_UNIT;

public class ResultView {

    public static final DecimalFormat moneyFormat = new DecimalFormat("###,###");

    public ResultView() {}

    public void displayAllLotteries(List<Lotto> lotteries) {
        System.out.println(String.format(LottoMessage.NUMBER_RESULT, lotteries.size()));
        lotteries.iterator()
                .forEachRemaining(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displayPercentageProfit(String percentageProfit) {
        System.out.println(percentageProfit);
    }

    public void displayWinStatistics() {
        System.out.println(LottoMessage.WIN_STATISTICS);
    }

    public void displaySeparator() {
        System.out.println(LottoMessage.LINE_SEPARATOR);
    }

    public void displayWinners(Map<LottoRank, Integer> result) {
        LottoRank.getAscendRank()
                .forEach(rank -> {
                    int sameCount = rank.getSameCount();
                    String outputLine =
                            String.format(SAMES_FORMAT, sameCount) +
                                    OPEN_BRACKET +
                                    moneyFormat.format(rank.getPrizeMoney()) +
                                    CLOSE_BRACKET +
                                    HYPHEN_WITH_SPACE +
                                    result.getOrDefault(rank, 0) +
                                    KOREA_BASICS_UNIT;

                    System.out.println(outputLine);
                });
    }
}
