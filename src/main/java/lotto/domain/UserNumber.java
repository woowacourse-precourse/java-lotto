package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserNumber {
    private static final String WIN_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 숫자, 쉼표 외의 문자를 입력하셨습니다.";
    private static final String BONUS_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 숫자 외의 문자를 입력하셨습니다.";
    private static final String SAME_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복되면 안 됩니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1~45 사이 숫자이어야 합니다.";

    private Lotto winNumbers;
    private int bonusNumber;

    public UserNumber(String winNumbers, String bonusNumber) {
        validateWinNumbersType(winNumbers);
        validateBonusNumbers(bonusNumber);
        validateSame(winNumbers, bonusNumber);

        this.winNumbers = new Lotto(toLotto(winNumbers));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateWinNumbersType(String winNumber) {
        if (!winNumber.matches("^[0-9,]*$")) {
            throw new IllegalArgumentException(WIN_NUMBER_TYPE_ERROR_MESSAGE);
        }
    }

    private void validateBonusNumbers(String bonusNumber) {
        validateBonusNumberType(bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateSame(String winNumbers, String bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(SAME_ERROR_MESSAGE);
        }
    }

    private void validateBonusNumberType(String bonusNumber) {
        if (!bonusNumber.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(BONUS_NUMBER_TYPE_ERROR_MESSAGE);
        }
    }

    private void validateRange(String number) {
        if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private List<Integer> toLotto(String inputNumber) {
        return Stream.of(inputNumber.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
