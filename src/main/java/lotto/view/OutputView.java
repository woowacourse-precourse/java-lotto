package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;

public class OutputView {
    private static final String BUY_LOTTOS_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_END_RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String WINNING_COUNT_RESULT_MESSAGE = "%d개 일치 (%,d원) - %d개\n";
    private static final String WINNING_COUNT_PLUS_BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String RATIO_OF_RETURN_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    public void printLottoNumbers(Lottos lottos) {
        System.out.println(String.format(BUY_LOTTOS_MESSAGE, lottos.getLottos().size()));
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printLottoResults(LottoResults lottoResults) {
        System.out.println(LOTTO_END_RESULT_MESSAGE);
        StringBuffer lottoResultsMessage = getLottoResultsMessage(lottoResults);
        System.out.println(lottoResultsMessage);
    }

    private StringBuffer getLottoResultsMessage(LottoResults lottoResults) {
        StringBuffer stringBuffer = new StringBuffer();
        String hitThreeNumbersResult = String.format(WINNING_COUNT_RESULT_MESSAGE, LottoRank.FIFTH.getWinningCount(), LottoRank.FIFTH.getReward(), lottoResults.getLottoResult(LottoRank.FIFTH));
        String hitFourNumbersResult = String.format(WINNING_COUNT_RESULT_MESSAGE, LottoRank.FOURTH.getWinningCount(), LottoRank.FOURTH.getReward(), lottoResults.getLottoResult(LottoRank.FOURTH));
        String hitFiveNumbersResult = String.format(WINNING_COUNT_RESULT_MESSAGE, LottoRank.THIRD.getWinningCount(), LottoRank.THIRD.getReward(), lottoResults.getLottoResult(LottoRank.THIRD));
        String hitFivePlusBonusNumbersResult = String.format(WINNING_COUNT_PLUS_BONUS_RESULT_MESSAGE, LottoRank.SECOND.getWinningCount(), LottoRank.SECOND.getReward(), lottoResults.getLottoResult(LottoRank.SECOND));
        String hitSixNumbersResult = String.format(WINNING_COUNT_RESULT_MESSAGE, LottoRank.FIRST.getWinningCount(), LottoRank.FIRST.getReward(), lottoResults.getLottoResult(LottoRank.FIRST));
        stringBuffer.append(hitThreeNumbersResult)
                .append(hitFourNumbersResult)
                .append(hitFiveNumbersResult)
                .append(hitFivePlusBonusNumbersResult)
                .append(hitSixNumbersResult);
        return stringBuffer;
    }

    public void printRatioOfReturn(LottoResults lottoResults) {
        System.out.println(String.format(RATIO_OF_RETURN_MESSAGE, lottoResults.getRatioOfReturn()));
    }
}
