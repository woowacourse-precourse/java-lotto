package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGrade;
import lotto.domain.Money;
import lotto.service.LottoStore;
import lotto.view.LottoPrinter;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoStore lottoStore;
    private final LottoPrinter lottoPrinter;

    private LottoController(LottoStore lottoStore, LottoPrinter lottoPrinter) {
        this.lottoStore = lottoStore;
        this.lottoPrinter = lottoPrinter;
    }

    public static LottoController create(LottoStore lottoStore, LottoPrinter lottoPrinter) {
        return new LottoController(lottoStore, lottoPrinter);
    }

    public void start() {
        Money money = new Money(lottoPrinter.inputer("구입금액을 입력해 주세요."));
        List<Lotto> lottos = lottoStore.buyLottos(money);
        lottoPrinter.lottosPrint(lottos);

        Lotto winningNumbers = lottoStore.confirmWinningNumbers(lottoPrinter.inputer("당첨 번호를 입력해 주세요."));
        int bonusNumber = lottoStore.confirmBonusNumber(lottoPrinter.inputer("보너스 번호를 입력해 주세요."));

        Map<LottoGrade, Integer> lottosResult = lottoStore.conversionLottosResult(lottos, winningNumbers, bonusNumber);
        lottoPrinter.lottoResultPrint(lottosResult);

        double calculationResult = lottoStore.revenueCalculator(money.getMoney(), lottosResult);
        lottoPrinter.revenueResultPrint(calculationResult);
    }
}
