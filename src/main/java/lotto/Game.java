package lotto;

public class Game {
    public void playGame() {
        new Print().inputMoney();
        int numberOfLottos = Input.inputPurchaseMoney();
        new Output().outputNumberOfLotto(numberOfLottos);
    }
}
