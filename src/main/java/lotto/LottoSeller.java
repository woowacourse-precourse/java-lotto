package lotto;

import java.util.List;

public class LottoSeller {

    private final LottoMachine lottoMachine;
    private final int ZERO = 0;
    private final int UNIT = 1000; // ENUM 고려?
    private MoneyInputController moneyInputController;


    public LottoSeller() {
        lottoMachine = new LottoMachine();
        moneyInputController = new MoneyInputController();

    }


    public LottoPurchaseInfo sellLotto() {



        List<Lotto> lottoNumbers = lottoMachine.issueLottoNumbers(1);





        return new LottoPurchaseInfo(lottoNumbers, Long.parseLong("1"));

    }

    public WinPrize checkMatchCount(Lotto buyerLotto) {

        WinPrize winPrize = lottoMachine.getWinPrize(buyerLotto);

        return winPrize;
    }
}
