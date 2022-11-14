package lotto.service;

import lotto.constant.LottoConstant;

public class Announce {

    static public void announceInputMessage() {
        System.out.println(LottoConstant.INPUT_MESSAGE);
    }

    static public void announcePurchaseMessage(int purchaseQuantity) {
        System.out.println("\n" + purchaseQuantity + LottoConstant.PURCHASE_MESSAGE);
    }

    static public void announceInputLottoNumbers() {
        System.out.println("\n" + LottoConstant.INPUT_LOTTO_NUMBERS);
    }

    static public void announceInputBonusNumber() {
        System.out.println("\n" + LottoConstant.INPUT_BONUS_NUMBER);
    }

    static public void announceWinningStatistics() {
        System.out.println("\n" + LottoConstant.WINNING_STATISTICS);
    }
}
