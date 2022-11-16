package lotto.view;

import static java.text.MessageFormat.*;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public enum OutputView {

    LOTTO_COUNT_MESSAGE("\n{0}개를 구매했습니다."),
    RESULT_START_MESSAGE("당첨 통계"),
    RESULT_SEPARATOR_MESSAGE("---"),
    LOTTO_RESULT_MESSAGE("{0}개 일치{1} ({2,number}원) - {3}개"),
    LOTTO_PROFIT_MESSAGE("총 수익률은 {0}%입니다."),
    BONUS_BALL_MESSAGE(", 보너스 볼 일치"),
    EMPTY_MESSAGE(""),
    ;

    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public static void printLottoInformation(List<Lotto> lottos) {
        System.out.println(format(LOTTO_COUNT_MESSAGE.toString(), lottos.size()));
        lottos.forEach(System.out::println);
    }

    public static void printResultInformation(List<Ranking> rankings, Double profit) {
        printResultStartMessage();
        printLottoResultMessage(rankings);
        printProfitResultMessage(profit);
    }

    private static void printProfitResultMessage(Double profit) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
        String formattedProfit = decimalFormat.format(profit);
        System.out.print(format(LOTTO_PROFIT_MESSAGE.toString(), formattedProfit));
    }

    private static void printLottoResultMessage(List<Ranking> rankings) {
        for (Ranking ranking : Ranking.rankingsOrderByPriceMoneyAsc()) {
            System.out.println(format(LOTTO_RESULT_MESSAGE.toString(),
                    ranking.getMatchCount(),
                    getBonusBallMessage(ranking),
                    ranking.getPrizeMoney(),
                    Collections.frequency(rankings, ranking)
            ));
        }
    }

    private static String getBonusBallMessage(Ranking ranking) {
        if (ranking.equals(Ranking.SECOND_PLACE)) {
            return BONUS_BALL_MESSAGE.toString();
        }
        return EMPTY_MESSAGE.toString();
    }

    private static void printResultStartMessage() {
        System.out.println(RESULT_START_MESSAGE);
        System.out.println(RESULT_SEPARATOR_MESSAGE);
    }
}
