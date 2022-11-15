package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoStore lottoStore;

    private LottoController(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public static LottoController create(LottoStore lottoStore) {
        return new LottoController(lottoStore);
    }

    public void start() {
        Money money = new Money(LottoPrinter.inputer("구입금액을 입력해 주세요."));
        List<Lotto> lottos = lottoStore.buyLottos(money);
        LottoPrinter.lottosPrint(lottos);

        Lotto winningNumbers = lottoStore.confirmWinningNumbers(LottoPrinter.inputer("당첨 번호를 입력해 주세요."));
        int bonusNumber = lottoStore.confirmBonusNumber(LottoPrinter.inputer("보너스 번호를 입력해 주세요."));

        Map<LottoGrade, Integer> lottosResult = lottoStore.conversionLottosResult(lottos, winningNumbers, bonusNumber);
        LottoPrinter.lottoResultPrint(lottosResult);
        double calculationResult = lottoStore.revenueCalculator(money.getMoney(), lottosResult);
        LottoPrinter.revenueResultPrint(calculationResult);
    }
}
