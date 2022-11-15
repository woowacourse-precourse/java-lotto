package lotto.LottoGame;

import java.util.List;
import lotto.lotto.Lotto;
import lotto.winning.WinningStatistical;

public interface LottoGamePrinter {
    void printRequestBuyingPrice();

    void printBoughtLottos(List<Lotto> lottos);

    void printRequestWinningNumber();

    void printRequestBonusNumber();

    void printWinningStatistical(WinningStatistical winningStatistical);
}
