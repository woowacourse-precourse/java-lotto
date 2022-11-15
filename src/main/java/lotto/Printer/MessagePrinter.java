package lotto.Printer;

import java.util.List;
import lotto.Object.LotteryTicketingMachine;
import lotto.Object.Lotto;

public class MessagePrinter {

    LotteryTicketingMachine lotteryTicketingMachine = new LotteryTicketingMachine();

    public void printInputMoneyMessage() {
        System.out.println(Message.INPUT_MONEY_MESSAGE.getPrintingMessage());
    }

    public void printPurchaseConfirmMessage(int howManyLotto) {
        System.out.print(howManyLotto);
        System.out.println(Message.PURCHASE_CONFIRM_MESSAGE.getPrintingMessage());
    }

    public void printPurchasedLotto(List<Lotto> lottoBundle) {
        for (int lottoBundleIndex = 0; lottoBundleIndex < lottoBundle.size(); lottoBundleIndex++) {
            System.out.println(lottoBundle.get(lottoBundleIndex).getNumbersToString());
        }
    }

    public void printInputWinningNumberMessage() {
        System.out.println(Message.INPUT_WINNING_NUMBER_MESSAGE.getPrintingMessage());
    }

    public void printInputBonusNumberMessage() {
        System.out.println(Message.INPUT_BONUS_NUMBER_MESSAGE.getPrintingMessage());
    }

    public void printWinningResult(List<Integer> winningNumberCount) {
        System.out.println(Message.WINNING_RESULT_MESSAGE_TITLE.getPrintingMessage());
        for (int index = 3; index < 8; index++) {
            System.out.println(Message.values()[index + 2].getPrintingMessage() + winningNumberCount.get(index) + "개");
        }
    }

    public void printEarningsRate (double earningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate * 100) + "%입니다.");
    }
}
