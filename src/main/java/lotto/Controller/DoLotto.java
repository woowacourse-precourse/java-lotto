package lotto.Controller;

import lotto.Printer.MessagePrinter;
import lotto.Object.Lotto;
import lotto.Object.LotteryTicketingMachine;
import lotto.Object.User;

public class DoLotto {

    MessagePrinter messagePrinter = new MessagePrinter();
    User user = new User();
    LotteryTicketingMachine lotteryTicketingMachine = new LotteryTicketingMachine();

    public void purchaseLotto() {
        messagePrinter.printInputMoneyMessage();
        user.setMoney();
        messagePrinter.printPurchaseConfirmMessage(lotteryTicketingMachine.ticketHowManyLotto(user.getMoney()));
    }

    public void makeLottoBundle() {
        int numberOfLotto;

        numberOfLotto = lotteryTicketingMachine.ticketHowManyLotto(user.getMoney());
        user.makeLottoBundle(numberOfLotto);

        messagePrinter.printPurchasedLotto(user.getLottoBundle());
    }

    public void makeWinningNumber() {
        messagePrinter.printInputWinningNumberMessage();
        user.inputWinningNumber();

        messagePrinter.printInputBonusNumberMessage();
        user.inputBonusNumber();
    }

    public void getPrizeMoney() {
        int howManyWinningNumber;
        boolean isBonusNumberCorrect;

        for (Lotto lotto : user.getLottoBundle()) {
            howManyWinningNumber = lotteryTicketingMachine.checkWinningNumber(user.getWinningNumber(),lotto);
            isBonusNumberCorrect = lotto.contains(user.getBonusNumber());
            user.countWinningNumber(howManyWinningNumber,isBonusNumberCorrect);
        }

        user.calculateEarning();

        messagePrinter.printWinningResult(user.getWinningNumberCounting());
        messagePrinter.printEarningsRate(user.calculateEarningRate());
    }

    public void play() throws IllegalArgumentException {
        try {
            purchaseLotto();
            makeLottoBundle();
            makeWinningNumber();
            getPrizeMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
