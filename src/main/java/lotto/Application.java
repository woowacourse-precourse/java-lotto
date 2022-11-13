package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.winningresult.WinningResultType;
import lotto.domain.winningresult.WinningResults;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.ui.formatter.OutputFormatter;
import lotto.ui.formatter.lottos.LottoFormatter;
import lotto.ui.formatter.lottos.LottosFormatter;
import lotto.ui.formatter.result.WinningResultFormatter;
import lotto.ui.formatter.result.WinningResultsFormatter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputFormatter<Lotto> lottoOutputFormatter = new LottoFormatter();
        OutputFormatter<Lottos> lottosOutputFormatter = new LottosFormatter(lottoOutputFormatter);
        OutputFormatter<WinningResultType> winningResultFormatter = new WinningResultFormatter();
        OutputFormatter<WinningResults> WinningResultsFormatter = new WinningResultsFormatter(winningResultFormatter);

        ResultView resultView = new ResultView(lottosOutputFormatter, WinningResultsFormatter);
        InputView inputView = new InputView();
        LottoApplication lottoApplication = new LottoApplication(inputView, resultView);

        try {
            lottoApplication.run();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
