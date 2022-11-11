package lotto;

public class MessagePrinter {

    public void printInputMoneyMessage() {
        System.out.println(Message.INPUT_MONEY_MESSAGE.getPrintingMessage());
    }

    public void printPurchaseConfirmMessage(int howManyLotto) {
        System.out.print(howManyLotto);
        System.out.println(Message.PURCHASE_CONFIRM_MESSAGE);
    }

    public void printInputWinningNumberMessage() {
        System.out.println(Message.INPUT_WINNING_NUMBER_MESSAGE.getPrintingMessage());
    }

    public void printInputBonusNumberMessage() {
        System.out.println(Message.INPUT_BONUS_NUMBER_MESSAGE.getPrintingMessage());
    }

    public void printWinningResult(String correct3, String correct4, String correct5, String correctBonus5, String correct6) {
        System.out.println(Message.WINNING_RESULT_MESSAGE_TITLE);
        System.out.println(Message.WINNING_RESULT_MESSAGE_3CORRECT+correct3+"개");
        System.out.println(Message.WINNING_RESULT_MESSAGE_4CORRECT+correct4+"개");
        System.out.println(Message.WINNING_RESULT_MESSAGE_5CORRECT+correct5+"개");
        System.out.println(Message.WINNING_RESULT_MESSAGE_5BONUS_CORRECT+correctBonus5+"개");
        System.out.println(Message.WINNING_RESULT_MESSAGE_6CORRECT+correct6);
    }

    public void printEarningsRate(double earningRate) {
        System.out.println("총 수익률은 "+String.format("%.1f",earningRate)+"%입니다.");
    }
}
