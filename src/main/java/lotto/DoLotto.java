package lotto;

import Printer.MessagePrinter;
import Character.Lotto;
import Character.LotteryTicketingMachine;
import Character.User;

public class DoLotto {

    public void play() throws IllegalArgumentException {

        MessagePrinter messagePrinter = new MessagePrinter();
        User user = new User();
        LotteryTicketingMachine lotteryTicketingMachine = new LotteryTicketingMachine();
        int numberOfLotto;

        messagePrinter.printInputMoneyMessage();
        user.setMoney();
        messagePrinter.printPurchaseConfirmMessage(lotteryTicketingMachine.ticketHowManyLotto(user.getMoney()));

        numberOfLotto = lotteryTicketingMachine.ticketHowManyLotto(user.getMoney());
        user.makeLottoBundle(numberOfLotto);
        messagePrinter.printPurchasedLotto(user.getLottoBundle());

        messagePrinter.printInputWinningNumberMessage();
        user.inputWinningNumber();

        messagePrinter.printInputBonusNumberMessage();
        user.inputBonusNumber();

        for (Lotto lotto : user.getLottoBundle()) {
            int howManyWinningNumber = lotteryTicketingMachine.checkWinningNumber(user.getWinningNumber(),lotto);
            boolean isBonusNumberCorrect = lotto.contains(user.getBonusNumber());
            user.countWinningNumber(howManyWinningNumber,isBonusNumberCorrect);
        }

        user.calculateEarning();

        messagePrinter.printWinningResult(
                Integer.toString(user.getWinningNumberCounting().get(3)),
                Integer.toString(user.getWinningNumberCounting().get(4)),
                Integer.toString(user.getWinningNumberCounting().get(5)),
                Integer.toString(user.getWinningNumberCounting().get(6)),
                Integer.toString(user.getWinningNumberCounting().get(7))
        );

        user.calculateEarningRate();

        messagePrinter.printEarningsRate(user.calculateEarningRate());

    }

}
