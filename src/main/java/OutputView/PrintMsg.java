package OutputView;

import lotto.Lotto;

import java.util.List;

import static OutputView.PrintComment.*;


public class PrintMsg {

    public static void purchasedMsg() {
        System.out.println(PURCHASED_MESSAGE.getMsg());
    }

    public static void numberOfLottoPurchasedMsg(int lottoCount) {
        System.out.println("\n" + lottoCount + LottoCount_MESSAGE.getMsg());
    }

    public static void purchasedLottosMsg(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getLottoNumber());
        }
    }

    public static void earningRateMsg(double earningRatio) {
        System.out.println(EARNING_HEADER_MESSAGE.getMsg() + earningRatio + EARNING_TAIL_MESSAGE.getMsg());
    }

    public static void winningMsg() {
        System.out.println(WINNING_MESSAGE.getMsg());
    }

    public static void bonusMsg() {
        System.out.println(BONUS_MESSAGE.getMsg());
    }
}
