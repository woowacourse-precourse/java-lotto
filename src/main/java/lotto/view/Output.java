package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.constants.WinningStatistics;
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

    public static void printWinningStatistics(int[] winningStatistics) {
        int index = 0;
        System.out.println(lotto.constants.Output.WINNING_Statistics.getMsg());
        for (WinningStatistics state : WinningStatistics.values()) {
            System.out.println(String.format(state.getMsg(), winningStatistics[index]));
            index++;
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(lotto.constants.Output.RATE_OF_RETURN.getMsg(), rateOfReturn));
    }
}
