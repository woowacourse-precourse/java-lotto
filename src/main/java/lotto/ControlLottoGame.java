package lotto;

import java.util.ArrayList;
import java.util.List;

public class ControlLottoGame {

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

        for (String inputNumber : inputNumbers) {
            String noSpace = inputNumber.trim();
            winningNumbers.add(Integer.parseInt(noSpace));
        }

        return winningNumbers;
    }

    public int inputToBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(input);

        if ((bonusNumber < 0) || (bonusNumber > 45)) {
            throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_INCORRECT_RANGE.get());
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.ERROR.get() + Message.ERROR_DUPLICATED.get());
        }

        return bonusNumber;
    }

    public float calculateEarningRate(List<Integer> winningCount, int quantity) {
        int payedPrice = quantity * 1000;
        int earnedPrice = 0;
        String earnedRate;

        earnedPrice += winningCount.get(0) * CorrectValue.THREE_CORRECT.get();
        earnedPrice += winningCount.get(1) * CorrectValue.FOUR_CORRECT.get();
        earnedPrice += winningCount.get(2) * CorrectValue.FIVE_CORRECT.get();
        earnedPrice += winningCount.get(3) * CorrectValue.SIX_CORRECT.get();
        earnedPrice += winningCount.get(4) * CorrectValue.FIVE_BONUS_CORRECT.get();
        double rate = (double) earnedPrice / payedPrice;
        earnedRate = String.format("%.1f", rate * 100);

        return Float.parseFloat(earnedRate);
    }
}

enum CorrectValue {
    THREE_CORRECT(5000),
    FOUR_CORRECT(50000),
    FIVE_CORRECT(1500000),
    FIVE_BONUS_CORRECT(30000000),
    SIX_CORRECT(2000000000);

    private final int value;

    CorrectValue(int value) {
        this.value = value;
    }

    public int get(){
        return value;
    }
}