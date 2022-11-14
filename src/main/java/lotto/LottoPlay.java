package lotto;

import lotto.constant.ErrorOutputMessage;
import lotto.util.MessageUtil;

import static lotto.constant.ErrorOutputMessage.*;

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
        }
    }
}

