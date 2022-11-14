package view;

import domain.Lotto;
import util.LottoMessage;
import util.LottoRank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static util.Constant.*;
import static util.LottoMessage.PROFIT_INFO;
import static util.LottoMessage.PERCENTAGE;
import static util.LottoMessage.SUFFIX;

public class ResultView {

    public static final DecimalFormat moneyFormat = new DecimalFormat("###,###");

    public ResultView() {}

    public void displayAllLotteries(List<Lotto> lotteries) {
        System.out.println(String.format(LottoMessage.NUMBER_RESULT, lotteries.size()));
        lotteries.iterator()
                .forEachRemaining(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displaySeparateLine() {
        System.out.println();
    }

    public void displayPercentageProfit(String percentageProfit) {
        System.out.println(PROFIT_INFO + percentageProfit + PERCENTAGE + SUFFIX);
    }

    public void displayWinStatistics() {
        System.out.println(LottoMessage.WIN_STATISTICS);
    }

    public void displaySeparator() {
        System.out.println(LINE_SEPARATOR);
    }

    public void displayWinners(Map<LottoRank, Integer> result) {
        LottoRank.getAscendRank()
                .forEach(rank -> {
                    int sameCount = rank.getSameCount();
                    String outputLine = String.format(SAMES_FORMAT, sameCount);

                    if (rank.isNeedBonusBall()) {
                        outputLine += SAME_BONUS_BALL;
                    }
                    outputLine += OPEN_BRACKET + moneyFormat.format(rank.getPrizeMoney()) + KOREA_MONEY_UNIT +
                            CLOSE_BRACKET + HYPHEN_WITH_SPACE + result.getOrDefault(rank, DEFAULT_ZERO) +
                            KOREA_BASICS_UNIT;
                    System.out.println(outputLine);
                });
    }
}
