package lotto;

import lotto.domain.LottoPrize;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumber;
import lotto.util.MessageUtil;

public class LottoPlay {

    private final MessageUtil messageUtil = new MessageUtil();

    private final LottoPurchase lottoPurchase = new LottoPurchase();

    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();

    public void play() {
        messageUtil.printPurchaseInput();
        try {
            LottoPurchase purchaseInfo = lottoPurchase.getPurchaseInfo();
            LottoWinningNumber winningNumbersInfo = lottoWinningNumber.getWinningNumbersInfo();
            LottoPrize lottoPrize = new LottoPrize(winningNumbersInfo);
            lottoPrize.getLottoStats(purchaseInfo.getUserLottos(), purchaseInfo.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

