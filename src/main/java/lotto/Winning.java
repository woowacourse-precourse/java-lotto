package lotto;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_OUT_OF_RANGE_ERROR = "로또 번호는 6개여야 합니다.";

    public Winning() {
    }

    public static List<Integer> makeWinningNumberList(String userInput) {
        String[] numbers = userInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String num : numbers) {
            winningNumbers.add(Integer.parseInt(num));
        }

        isValidateWinningNumberSize(winningNumbers);

        return winningNumbers;
    }

    public static void isValidateWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_OUT_OF_RANGE_ERROR);
        }
    }
}
