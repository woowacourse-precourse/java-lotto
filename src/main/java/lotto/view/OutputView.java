package lotto.view;

import static java.text.MessageFormat.*;

import java.util.Collections;
import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoRank;

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

    public static void printResultInformation(List<LottoRank> lottoRanks, Double profit) {
        printResultStartMessage();
        printLottoResultMessage(lottoRanks);
        printProfitResultMessage(profit);
    }

    private static void printProfitResultMessage(Double profit) {
        System.out.print(format(LOTTO_PROFIT_MESSAGE.toString(), profit));
    }

    private static void printLottoResultMessage(List<LottoRank> lottoRanks) {
        for (LottoRank lottoRank : LottoRank.lottoRanksOrderByPriceMoneyAsc()) {
            System.out.println(format(LOTTO_RESULT_MESSAGE.toString(),
                    lottoRank.getMatchCount(),
                    getBonusBallMessage(lottoRank),
                    lottoRank.getPrizeMoney(),
                    Collections.frequency(lottoRanks, lottoRank)
            ));
        }
    }

    private static String getBonusBallMessage(LottoRank lottoRank) {
        if (lottoRank.equals(LottoRank.SECOND_PLACE)) {
            return BONUS_BALL_MESSAGE.toString();
        }
        return EMPTY_MESSAGE.toString();
    }

    private static void printResultStartMessage() {
        System.out.println(RESULT_START_MESSAGE);
        System.out.println(RESULT_SEPARATOR_MESSAGE);
    }
}
