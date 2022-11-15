package lotto;

import java.util.List;
import lotto.application.LottoService;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinNumbers;
import lotto.presentation.Input;
import lotto.presentation.Output;

public class LottoSimulator {

    private static final LottoService lottoService = LottoService.getInstance();

    public static void run() {
        List<Lotto> lottos = initLottos();

        WinNumbers winNumbers = initWinNumbers();

        draw(lottos, winNumbers);
    }

    private static List<Lotto> initLottos() {
        long amount = Input.inputAmount();
        List<Lotto> lottos = lottoService.sellLotto(amount);
        Output.printLottos(lottos);
        return lottos;
    }

    private static WinNumbers initWinNumbers() {
        List<Integer> numbers = Input.inputNumbers();
        int bonusNumber = Input.inputNumber();
        return new WinNumbers(numbers, bonusNumber);
    }

    private static void draw(List<Lotto> lottos, WinNumbers winNumbers) {
        List<Result> results = lottoService.compareLottos(winNumbers, lottos);
        Output.printResult(results);
        Output.printRate(results);
    }
}
