package lotto;

public class PlayLottoGame {

    WinningChecker winningChecker;
    WinningNumber winningNumber;
    Counter counter;
    int numberOfLotto;

    public PlayLottoGame() {

        enterMoney();
        enterWinningNumber();
        createWinningChecker();

        while (haveOpportunityOfWinning()) {
            checkWinning();
        }
        printWinningHistory();
    }

    private void enterMoney() {
        counter = new Counter();
        counter.putMoney();
        numberOfLotto = counter.getNumberOfLotto();
    }

    private void enterWinningNumber() {
        winningNumber = new WinningNumber();
        winningNumber.createWinningNumbers();
        winningNumber.createBonusNumber();
    }

    private void createWinningChecker() {
        winningChecker = new WinningChecker(winningNumber);
    }

    private void checkWinning() {
        Lotto lotto = new Lotto(new LottoCreator().createNumbers());
        winningChecker.setWinningChart(lotto.getNumbers());
    }

    private boolean haveOpportunityOfWinning() {
        numberOfLotto -= 1;
        return numberOfLotto >= 0;
    }

    private void printWinningHistory() {
        new Printer(counter.getMoney(), winningChecker.getWinningChart());
    }
}
