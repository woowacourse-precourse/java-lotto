package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.controller.LottoMachineController;
import lotto.model.Lotto;

public class Output {
    public static void printStartMsg() {
        System.out.println(lotto.constants.Output.PURCHASE_AMOUNT_INPUT.getMsg());
    }

    public static void printPurchaseMsg(int number) {
        System.out.println(number + lotto.constants.Output.PURCHASE_AMOUNT_OUTPUT.getMsg());
    }

    public static void printWinningMsg() {
        System.out.println(lotto.constants.Output.WINNING_NUMBER_INPUT.getMsg());
    }

    public static void printBonusMsg() {
        System.out.println(lotto.constants.Output.BONUS_NUMBER_INPUT.getMsg());
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(LottoMachineController.toListLotto(lotto));
        }
    }

    public static void printLotto(int[] lotto) {
        System.out.println(Arrays.toString(lotto));
    }
}
