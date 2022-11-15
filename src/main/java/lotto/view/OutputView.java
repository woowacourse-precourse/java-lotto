package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class OutputView {

    private static final String LOTTO_TICKET_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_RESULT_STATISTICS_MESSAGE = "당첨 통계\n";
    private static final String LOTTO_RESULT_DIVIDER_MESSAGE = "---\n";
    private static final String LOTTO_RESULT_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private static final String LOTTO_HIT_MESSAGE = "%d개 일치";
    private static final String LOTTO_BONUS_HIT_MESSAGE = ", 보너스 볼 일치";
    private static final String LOTTO_REWARD_MESSAGE = " (%s원)";
    private static final String LOTTO_ACTUAL_HIT_MESSAGE = "%d개\n";
    private static final String NUMBER_COMMA_REGEX = "\\B(?=(\\d{3})+(?!\\d))";
    private static final String COMMA = ",";
    private static final String HYPHEN = " - ";

    public static void outputLottoTicketCount(int ticketCount) {
        System.out.printf(LOTTO_TICKET_COUNT_MESSAGE, ticketCount);
    }

    public static void outputLottoTicket(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumber().toString());
        }
    }

    public static void outputLottoRankResult(LottoResult lottoResults) {
        System.out.print(LOTTO_RESULT_STATISTICS_MESSAGE);
        System.out.print(LOTTO_RESULT_DIVIDER_MESSAGE);

        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        for (Rank rank : ranks) {
            outputLottoRankFormat(rank);
            outputLottoResultFormat(rank, lottoResults);
        }
    }

    private static void outputLottoRankFormat(Rank rank) {
        int hit = rank.getHit();
        boolean hasBonusHit = rank.getHasBonusHit();
        String reward = Integer.toString(rank.getReward());
        reward = reward.replaceAll(NUMBER_COMMA_REGEX, COMMA);

        if (hit == 0) {
            return ;
        }
        System.out.printf(LOTTO_HIT_MESSAGE, hit);
        if (hit == 5 && hasBonusHit) {
            System.out.printf(LOTTO_BONUS_HIT_MESSAGE);
        }
        System.out.printf(LOTTO_REWARD_MESSAGE, reward);
        System.out.printf(HYPHEN);
    }

    private static void outputLottoResultFormat(Rank rank, LottoResult lottoResults) {
        int hit = rank.getHit();
        if (hit == 0) {
            return ;
        }
        Integer hitCount = lottoResults.getLottoResult().get(rank);
        if (hitCount == null) {
            hitCount = 0;
        }
        System.out.printf(LOTTO_ACTUAL_HIT_MESSAGE, hitCount);
    }

    public static void outputLottoProfit(double profit) {
      System.out.printf(LOTTO_RESULT_PROFIT_MESSAGE, profit);
    }
    
    public static void printErrorMessage(String errorMessage) {
        System.out.printf(errorMessage);
    }
}
