package lotto;

public class DoLotto {

    public void play() {

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
                Integer.toString(user.getWinningNumberCounting().get("fifth")),
                Integer.toString(user.getWinningNumberCounting().get("fourth")),
                Integer.toString(user.getWinningNumberCounting().get("third")),
                Integer.toString(user.getWinningNumberCounting().get("second")),
                Integer.toString(user.getWinningNumberCounting().get("first")));

        user.calculateEarningRate();

        messagePrinter.printEarningsRate(user.calculateEarningRate());









    }


}
