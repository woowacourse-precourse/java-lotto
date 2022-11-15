package view;

import lotto.Lotto;
import utills.Earning;
import winning.WinningHistory;

import java.util.List;

import static view.PrintMessage.*;


public class Output {

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

    public static void printHistory(WinningHistory history) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + history.getFifthWinningCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + history.getForthWinningCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + history.getThirdWinningCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + history.getSecondWinningCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + history.getFirstWinningCount() + "개");
    }

    public static void printResult(int purchasedAmount, Earning earning) {
        Output.printHistory(earning.getWinningHistory());
        Output.earningRateMsg(earning.rateCalculate(purchasedAmount));
    }
}
