package lotto.config;

import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.ui.formatter.lottos.LottoFormatter;
import lotto.ui.formatter.lottos.LottosFormatter;
import lotto.ui.formatter.result.WinningResultFormatter;
import lotto.ui.formatter.result.WinningResultsFormatter;

public class LottoDependencyManager {
    private InputView inputView;
    private ResultView resultView;

    public InputView inputView() {
        if (inputView == null) {
            this.inputView = new InputView();
        }

        return inputView;
    }

    public ResultView resultView() {
        if (resultView == null) {
            this.resultView = new ResultView(lottosFormatter(), winningResultsFormatter());
        }

        return resultView;
    }

    private LottosFormatter lottosFormatter() {
        return new LottosFormatter(lottoFormatter());
    }

    private LottoFormatter lottoFormatter() {
        return new LottoFormatter();
    }

    private WinningResultsFormatter winningResultsFormatter() {
        return new WinningResultsFormatter(winningResultFormatter());
    }

    private WinningResultFormatter winningResultFormatter() {
        return new WinningResultFormatter();
    }
}
