package lotto.view;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import lotto.domain.LottoRank;

public class ResultMessage {
    private static final String MESSAGE_WINNING_HISTORY = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_NUMER_MATCH = "5개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String HYPHEN = "---";
    private static final String YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final NumberFormat numberformat = NumberFormat.getInstance();

    public void winningResultMessage(LinkedHashMap<LottoRank, Integer> result) {
        for (LottoRank lottoRank : result.keySet()) {
            if (lottoRank.getCount() == LottoRank.FIVE_MATCH_AND_BONUS_MATCH.getCount()) {
                bonusMessage(lottoRank, result);
                continue;
            }
            resultMessage(lottoRank, result);
        }
    }

    private void bonusMessage(LottoRank lottoRank, LinkedHashMap<LottoRank, Integer> result) {
        String format = String.format(BONUS_NUMER_MATCH, numberformat.format(lottoRank.getMoney()),
                result.get(lottoRank));
        System.out.println(format);
    }

    private void resultMessage(LottoRank lottoRank, LinkedHashMap<LottoRank, Integer> result) {
        String format = String.format(MESSAGE_WINNING_HISTORY, lottoRank.getCount(),
                numberformat.format(lottoRank.getMoney()),
                result.get(lottoRank));
        System.out.println(format);
    }

    public void winningStatisticsPrint() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(HYPHEN);
    }

    public void yieldMessage(float yield) {
        String format = String.format(YIELD_MESSAGE, yield);
        System.out.println(format);
    }
}
