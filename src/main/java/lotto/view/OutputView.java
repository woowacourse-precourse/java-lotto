package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResults;
import lotto.domain.LottoWin;
import lotto.domain.Lottos;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoWin.LOSER;
import static lotto.util.CharacterUnits.*;
import static lotto.view.InputViewMessage.NOTICE_PURCHASE_LOTTO_COUNT;
import static lotto.view.OutputViewMessage.*;

public class OutputView {
    private static final DecimalFormat prizeFormat = new DecimalFormat("###,###");
    private static final DecimalFormat percentFormat = new DecimalFormat("###,###.0%");

    public void printLottoNumber(Lottos lottos) {
        StringBuilder lottoNumberBuilder = new StringBuilder();
        for (Lotto lotto : lottos.getLottos()) {
            parseToLottoNumbers(lottoNumberBuilder, lotto);
        }
        System.out.print(lottoNumberBuilder);
    }

    public void printLottoResult(LottoResults lottoResults) {
        System.out.print(NOTICE_WINNER_STATISTIC.getMessage());
        Map<LottoWin, Integer> lottoWinResults = lottoResults.getLottoResults();
        lottoWinResults.remove(LOSER);
        lottoWinResults.forEach((lottoWin, winCount) -> System.out.print(parseLottoStatics(lottoWin, winCount)));
        System.out.printf(NOTICE_TOTAL_RATE.getMessage(), percentFormat.format(lottoResults.totalRate()));
    }
    public void printPurchaseTicketCounts(int size) {
        System.out.printf(NOTICE_PURCHASE_LOTTO_COUNT.getMessage(), size);
    }

    private void parseToLottoNumbers(StringBuilder lottoNumberBuilder, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        lottoNumberBuilder.append(LEFT_CASE.getUnit());
        lottoNumbers.forEach(number -> lottoNumberBuilder.append(number)
                .append(COMMA.getUnit())
                .append(SPACE.getUnit()));
        lottoNumberBuilder.replace(
                lottoNumberBuilder.length() - 2, lottoNumberBuilder.length(),
                RIGHT_CASE.getUnit() + ENTER.getUnit());
    }

    private String parseLottoStatics(LottoWin lottoWin, int winCount) {
        if (lottoWin.isAnyBonus()) {
            return String.format(NOTICE_WINNER_LOTTO_RESULT_WITH_BONUS_BALL.getMessage(),
                    lottoWin.getSameNumberCount(), prizeFormat.format(lottoWin.getPrize()), winCount);
        }
        return String.format(NOTICE_WINNER_LOTTO_RESULT.getMessage(),
                lottoWin.getSameNumberCount(), prizeFormat.format(lottoWin.getPrize()), winCount);
    }
}
