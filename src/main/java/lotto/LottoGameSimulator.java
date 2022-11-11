package lotto;

public class LottoGameSimulator {
    private Money money;
    public LottoGameSimulator() {
    }

    public void run() {
        getInputOfMoney();
        printGeneratedLotto();
        getInputOfWinningNumbers();
        getInputOfBonusNumber();
        printResult();
    }

    public void getInputOfMoney() {
        MessagePrinter.printMoneyInputRequest();
        String moneyInput = Inputter.readLine();
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
