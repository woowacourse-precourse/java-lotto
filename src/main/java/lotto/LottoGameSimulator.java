package lotto;

public class LottoGameSimulator {
    private final MessagePrinter messagePrinter;
    public LottoGameSimulator() {
        messagePrinter = new MessagePrinter();
    }

    public void run() {
        getInputOfMoney();
        printGeneratedLotto();
        getInputOfWinningNumbers();
        getInputOfBonusNumber();
        printResult();
    }

    public void getInputOfMoney() {
        messagePrinter.printMoneyInputRequest();
    }

    public void printGeneratedLotto() {

    }

    public void getInputOfWinningNumbers() {

    }

    public void getInputOfBonusNumber() {

    }

    public void printResult() {

    }
}
