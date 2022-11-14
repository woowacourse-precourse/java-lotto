package lotto;

public class Game {
    public void playGame() {
        new Print().inputMoney();
        int purchaseMoney = Input.inputPurchaseMoney();
        new Output().outputNumberOfLotto(purchaseMoney);
    }
}
