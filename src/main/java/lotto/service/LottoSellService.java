package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPurchaseInfo;
import lotto.domain.WinPrize;
import lotto.message.input.MoneyInputController;

import java.util.List;

public class LottoSellService {

    private final LottoMachine lottoMachine;
    private final int LOTTO_PER_PRICE = 1000;
    private MoneyInputController moneyInputController;

    public LottoSellService() {
        lottoMachine = new LottoMachine();
        moneyInputController = new MoneyInputController();
    }


    public LottoPurchaseInfo sellLotto() {
        String purchaseMoney = moneyInputController.input();
        moneyInputController.validate(purchaseMoney);

        List<Lotto> lottoNumbers = lottoMachine.issueLottoNumbers(Long.parseLong(purchaseMoney) / LOTTO_PER_PRICE);

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
