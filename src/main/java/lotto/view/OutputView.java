package lotto.view;

import lotto.model.Lotto;
import lotto.enums.Ranking;

import static lotto.enums.PrintMsg.*;

import java.util.List;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println(LINE_BREAK.getMessage() + lottoCount + OUTPUT_PURCHASE_LOTTO.getMessage());
    }

    public void printLottoNumber(List<Lotto> lottoNumbers) {
        for (int lottoCount = 0; lottoCount < lottoNumbers.size(); lottoCount++) {
            System.out.println(lottoNumbers.get(lottoCount).getNumbers());
        }
    }

    public void printWinningResult(List<Ranking> winningResult) {
        System.out.println(LINE_BREAK.getMessage() + OUTPUT_WINNING_RESULT.getMessage());
        for (Ranking rank : winningResult) {
            System.out.println(rank.getMessage() + rank.getWinningResult() + OUTPUT_COUNT.getMessage());
        }
    }

    public void printLottoYield(String lottoYield) {
        System.out.println(OUTPUT_TOTAL_YIELD.getMessage() + lottoYield + OUTPUT_POSTFIX.getMessage());
    }
}
