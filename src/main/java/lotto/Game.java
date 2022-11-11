package lotto;

public class Game {
    private View view = new View();
    private int validAmount;

    public Game() {
        view.printAmountInput();
    }

    public void startLotto() {

        if (!setAmount()) {
            return;
        }

    }

    public boolean setAmount() {
        int amount;

        amount = view.getAmount();

        if (amount == -1) {
            return false;
        }

        this.validAmount = amount;
        return true;
    }

}
