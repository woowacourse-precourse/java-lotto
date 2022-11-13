package lotto;

import lotto.GenerateLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlLottoGame {
    private final int THREE_CORRECT = 5000;
    private final int FOUR_CORRECT = 50000;
    private final int FIVE_CORRECT = 1500000;
    private final int FIVE_BONUS_CORRECT = 30000000;
    private final int SIX_CORRECT = 2000000000;

    ControlLottoGame() {
    }

    public int priceToQuantity(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_INCORRECT_PRICE.get());
        }
        return input / 1000;
    }

    public List<Integer> inputToWinningNumbers(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] inputNumbers = input.split(",");

        for(int i = 0; i<inputNumbers.length; i++){
            String noSpace = inputNumbers[i].trim();
            winningNumbers.add(Integer.parseInt(noSpace));
        }

        return winningNumbers;
    }

    public int calculateEarningRate(List<Integer> winningCount, int quantity) {
        int payedPrice = quantity * 1000;
        int earnedPrice = 0;
        String earnedRate;

        earnedPrice += winningCount.get(0) * THREE_CORRECT;
        earnedPrice += winningCount.get(1) * FOUR_CORRECT;
        earnedPrice += winningCount.get(2) * FIVE_CORRECT;
        earnedPrice += winningCount.get(3) * SIX_CORRECT;
        earnedPrice += winningCount.get(4) * FIVE_BONUS_CORRECT;
        earnedRate = String.format(".1f", (earnedPrice/payedPrice)*100);

        return Integer.parseInt(earnedRate);
    }
}
