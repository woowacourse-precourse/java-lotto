package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.Lotto.LOTTO_NUMBER_LENGTH_ZERO;

public class LottoWinningNumber {

    public static final String WINNING_NUMBER_SPACE = " ";
    private static final char WINNING_NUMBER_INPUT_FORM_CRITERIA = ',';
    private static final String WINNING_NUMBER_SPLIT_CRITERIA = ",";
    private static final int DEFAULT_VALUE = 0;
    private static final int WINNING_NUMBER_INPUT_COMMA_COUNT = 5;

    private final Lotto winningNumber;

    public LottoWinningNumber(String winningNumber) {
        this.winningNumber = new Lotto(validate(winningNumber));
    }

    private List<Integer> validate(String winningNumber) {
        validateEmpty(winningNumber);
        validateBlank(winningNumber);
        validateInputForm(winningNumber);
        return validateNumber(separate(winningNumber));
    }

    private void validateEmpty(String winningNumber) {
        if (winningNumber.length() == LOTTO_NUMBER_LENGTH_ZERO) {
            throw new IllegalArgumentException("[ERROR] 입력을 하지 않았습니다.");
        }
    }

    private void validateBlank(String winningNumber) {
        if (winningNumber.contains(WINNING_NUMBER_SPACE)) {
            throw new IllegalArgumentException("[ERROR] 입력 값의 공백이 포함 되어있습니다.");
        }
    }

    private void validateInputForm(String winningNumber) {
        int count = DEFAULT_VALUE;
        for (int i = 0; i < winningNumber.length(); i++) {
            if (winningNumber.charAt(i) == WINNING_NUMBER_INPUT_FORM_CRITERIA) {
                count++;
            }
        }
        if (count != WINNING_NUMBER_INPUT_COMMA_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 사이에 콤마를 넣어주세요.");
        }
    }

    private List<String> separate(String winningNumber) {
        return Arrays.asList(winningNumber.split(WINNING_NUMBER_SPLIT_CRITERIA));
    }

    private List<Integer> validateNumber(List<String> winningNumber) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String number : winningNumber) {
                numbers.add(Integer.parseInt(number));
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호중 숫자가 아닌 값이 있습니다.");
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

}
