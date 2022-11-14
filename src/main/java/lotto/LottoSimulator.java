package lotto;

import java.util.List;
import lotto.application.LottoService;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinNumbers;
import lotto.presentation.Input;
import lotto.presentation.Output;

public class LottoSimulator {

    public static void run() {
        long amount = Input.inputAmount();

        LottoService lottoService = LottoService.getInstance();
        List<Lotto> lottos = lottoService.sellLotto(amount);
        Output.printLottos(lottos);

        List<Integer> numbers = Input.inputNumbers();
        int bonusNumber = Input.inputNumber();
        WinNumbers winNumbers = new WinNumbers(numbers, bonusNumber);

        List<Result> results = lottoService.compareLottos(winNumbers, lottos);
        Output.printResult(results);
        Output.printRate(results);
    }
}
