package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.WinPrize;
import lotto.message.PrintController;
import lotto.message.input.MoneyInputController;

import java.util.List;

public class LottoSellService {

    private final LottoMachine lottoMachine;
    private final int ZERO = 0;
    private final int UNIT = 1000; // ENUM 고려?
    private MoneyInputController moneyInputController;
    private PrintController printController;

    public LottoSellService() {
        lottoMachine = new LottoMachine();
        moneyInputController = new MoneyInputController();
        printController = new PrintController();
    }


    public LottoPurchaseInfo sellLotto() {

        String purchaseMoney = moneyInputController.input();
        moneyInputController.validate(purchaseMoney);

        List<Lotto> lottoNumbers = lottoMachine.issueLottoNumbers(Long.parseLong(purchaseMoney) / UNIT);

        return new LottoPurchaseInfo(lottoNumbers, Long.parseLong(purchaseMoney));

    }

    public void inputNumber() {
        lottoMachine.inputWinNumber();
        lottoMachine.inputBonusNumber();
    }

    public WinPrize checkMatchCount(Lotto buyerLotto) {

        WinPrize winPrize = lottoMachine.getWinPrize(buyerLotto);

        return winPrize;
    }
}
