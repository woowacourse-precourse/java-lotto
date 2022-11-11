package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.result.Result;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.ui.formatter.OutputFormatter;
import lotto.ui.formatter.lottos.LottoFormatter;
import lotto.ui.formatter.lottos.LottosFormatter;
import lotto.ui.formatter.result.ResultFormatter;
import lotto.util.BonusNumberValidator;
import lotto.util.WinNumbersValidator;
import lotto.util.LottoPurchasedAmountValidator;
import lotto.util.Validator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputFormatter<Lotto> lottoOutputFormatter = new LottoFormatter();
        OutputFormatter<Lottos> lottosOutputFormatter = new LottosFormatter(lottoOutputFormatter);
        OutputFormatter<Result> resultOutputFormatter = new ResultFormatter();

        Validator lottoPurchasedAmountValidator = new LottoPurchasedAmountValidator();
        Validator winNumbersValidator = new WinNumbersValidator();
        Validator bonusNumberValidator = new BonusNumberValidator();

        ResultView resultView = new ResultView(lottosOutputFormatter, resultOutputFormatter);
        InputView inputView = new InputView(lottoPurchasedAmountValidator, winNumbersValidator,
                bonusNumberValidator);
        LottoApplication lottoApplication = new LottoApplication(inputView, resultView);

        lottoApplication.run();
    }
}
