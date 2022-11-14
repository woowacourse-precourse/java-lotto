package lotto;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_OUT_OF_RANGE_ERROR = "로또 번호는 6개여야 합니다.";
    private static final String WINNING_NOT_NUMBER_ERROR = "입력 값이 숫자가 아닙니다.";
    private static final String WINNING_NOT_IN_RANGE_ERROR = "당첨번호는 1 ~ 45 사이의 수 이어야 합니다.";
    private static final String WINNING_DUPLICATED = "당첨번호에 중복이 있습니다.";
    private static final String BONUS_NUMBER_NOT_NUMBER = "보너스 번호는 숫자여야 합니다.";
    private static final String BONUS_NUMBER_OUT_OF_RANGE = "보너스 번호는 1 ~ 45 사이의 수 이어야 합니다.";

    public Winning() {
    }

    public static List<Integer> makeWinningNumberList(String userInput) {
        String[] numbers = userInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String num : numbers) {
            validateNumber(num);
            winningNumbers.add(Integer.parseInt(num));
        }

        validateNumbers(winningNumbers);

        return winningNumbers;
    }

    public static void prize(List<Lotto> lottoTickets, List<Integer> winningNumber, String bonusNumber) {
        isValidateBonusNumber(bonusNumber);
    }

    private static void validateNumbers(List<Integer> winningNumbers) {
        isDuplicatedWinningNumber(winningNumbers);
        isValidateWinningNumberSize(winningNumbers);
    }

    private static void validateNumber(String num) {
        isValidateWinningNumber(num);
        isValidateWinningNumberRange(num);
    }

    private static void isValidateWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_OUT_OF_RANGE_ERROR);
        }
    }

    private static void isValidateWinningNumber(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NOT_NUMBER_ERROR);
        }
    }

    private static void isValidateWinningNumberRange(String num) {
        int result = Integer.parseInt(num);

        if (result < 1 || result > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NOT_IN_RANGE_ERROR);
        }
    }

    private static void isDuplicatedWinningNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_DUPLICATED);
        }
    }

    private static void isValidateBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_NOT_NUMBER);
        }
    }

    private static void isValidateBonusNumberRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_OUT_OF_RANGE);
        }
    }
}
