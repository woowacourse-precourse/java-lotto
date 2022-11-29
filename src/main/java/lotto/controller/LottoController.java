package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.ConfirmationWinningService;
import lotto.service.PurchaseService;
import lotto.service.RegisterWinningNumberService;

import java.util.List;

public class LottoController {
    private final PurchaseService purchaseService;
    private final RegisterWinningNumberService registerWinningNumberService;
    private final ConfirmationWinningService confirmationWinningService;

    public LottoController() {
        this.purchaseService = new PurchaseService();
        this.registerWinningNumberService = new RegisterWinningNumberService();
        this.confirmationWinningService = new ConfirmationWinningService();
    }

    public void start() {
        List<Lotto> lottos = purchaseService.purchase();
        WinningLotto winningLotto = registerWinningNumberService.register();
        confirmationWinningService.confirm(lottos, winningLotto);
    }
}
