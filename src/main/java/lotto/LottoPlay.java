package lotto;

import lotto.util.MessageUtil;

import java.util.List;

public class LottoPlay {

    private final MessageUtil messageUtil = new MessageUtil();

    private final LottoPurchase lottoPurchase = new LottoPurchase();

    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();

    public void play() {
        messageUtil.printPurchaseInput();
        List<Lotto> userLottos = lottoPurchase.getPurchaseInfo();
        LottoWinningNumber winningNumbersInfo = lottoWinningNumber.getWinningNumbersInfo();
        LottoPrize lottoPrize = new LottoPrize(winningNumbersInfo);

    }

}

