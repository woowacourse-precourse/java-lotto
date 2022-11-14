package lotto;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_OUT_OF_RANGE_ERROR = "로또 번호는 6개여야 합니다.";
    private static final String WINNING_NOT_NUMBER_ERROR = "입력 값이 숫자가 아닙니다.";
    private static final String WINNING_NOT_IN_RANGE_ERROR = "당첨번호는 1 ~ 45 사이의 수 여야 합니다.";

    public Winning() {
    }

    public static List<Integer> makeWinningNumberList(String userInput) {
        String[] numbers = userInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String num : numbers) {
            isValidateWinningNumber(num);
            isValidateWinningNumberRange(num);
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

    public static void isValidateWinningNumber(String num) {
        try {
            Integer.parseInt(num);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NOT_NUMBER_ERROR);
        }
    }

    public static void isValidateWinningNumberRange(String num) {
        int result = Integer.parseInt(num);

        if(result < 1 || result > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NOT_IN_RANGE_ERROR);
        }
    }
}
