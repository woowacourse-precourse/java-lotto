package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

import java.util.List;

import static lotto.domain.BonusNumber.checkWinningResult;
import static lotto.domain.Lotto.lottosGenerator;
import static lotto.utils.Input.*;
import static lotto.utils.Output.*;

public class LottoController {
    public void executeLottoProgram() {
        PurchaseAmount amount = enterPurchaseAmount();
        int lottoNum = amount.getLottoNum();
        List<Lotto> lottos = lottosGenerator(lottoNum);

        printLottoInfo(lottoNum, lottos);

        WinningLotto winningLotto = enterWinningLotto();
        BonusNumber bonusNumber = enterBonusNumber(winningLotto);

        checkWinningResult(lottos, winningLotto, bonusNumber);
        printResultMessage();
        printEarningRate(amount);
    }
}
