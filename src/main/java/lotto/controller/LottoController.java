package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static LottoService lottoService = new LottoService();

    public static void run() {
        InputView.printInputMoneyMessage();
        String input = Console.readLine();
        Lottos lottos = lottoService.purchaseLottos(input);
        OutputView.printLottosHistory(lottos);
    }
}
