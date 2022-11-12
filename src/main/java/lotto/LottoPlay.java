package lotto;

import lotto.util.MessageUtil;

import java.util.List;

public class LottoPlay {

    private final MessageUtil messageUtil = new MessageUtil();

    private final LottoPurchase lottoPurchase = new LottoPurchase();

    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();

    private final LottoPrize lottoPrize = new LottoPrize();

    public void play() {
        messageUtil.printPurchaseInput();
        List<Lotto> userLottos = lottoPurchase.getPurchaseInfo();
        LottoWinningNumber info = lottoWinningNumber.getWinningNumbersInfo();

    }

}

