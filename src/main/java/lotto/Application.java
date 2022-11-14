package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        int purchaseAmount = input.getPurchaseAmount();
        List<Integer> winningNumber = input.getWinningNumber();
    }
}
