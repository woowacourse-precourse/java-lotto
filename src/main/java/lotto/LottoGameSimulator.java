package lotto;

public class LottoGameSimulator {
    private MessagePrinter messagePrinter;
    private Inputter inputter;
    private Money money;
    public LottoGameSimulator() {
        messagePrinter = new MessagePrinter();
        inputter = new Inputter();
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
        String moneyInput = inputter.readLine();
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
