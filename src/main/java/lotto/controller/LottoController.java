package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.util.ValidUtil;
import lotto.view.Input;
import lotto.view.Output;

import java.util.EnumMap;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    private Amounts amounts;

    private WinningNumber winningNumber;

    private final ValidUtil validUtil;

    private Output output;
    private Input input;

    public LottoController(LottoService lottoService, ValidUtil validUtil) {
        this.lottoService = lottoService;
        this.validUtil = validUtil;
    }

    public void start() {
        input = new Input(this.validUtil);
        output = new Output();

        amounts = input.inputPurchasingAmount();
        List<Lotto> lottos = lottoService.purchaseLotto(amounts);

        output.printGeneratedLotto(lottos);

        winningNumber = input.inputBonusNumber(input.inputWinningNumber());

        WinStatistics ranks = lottoService.compareAllLottoAndWinningNumber(amounts, lottos,
                winningNumber);


        output.printWinningHistory(ranks);

    }
}
