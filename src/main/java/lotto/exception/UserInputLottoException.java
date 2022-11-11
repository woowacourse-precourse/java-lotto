package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputLottoException {

    private final static int PERMITTED_LOTTO_LENGTH = 6;
    private final static int PERMITTED_BONUS_LENGTH = 1;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private static final String ONLY_NUMBER_REGEX = "[1-45]+";

    public void validateLotto(String inputNumbers, String inputBonusNumber) {
        validateLottoNumbersLength(inputNumbers);
        validateOverlapNumbers()
        validateNumbersPermittedRange();
        validateBonusNumberIsNumber(inputBonusNumber);

    }

    public void validateLottoNumbersLength(String inputNumbers) {
        if (inputNumbers.replace(",", "").length() != PERMITTED_LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateOverlapNumbers(List<Integer> inputNumbers) {
        Set<Integer> numbers = new HashSet<>();
        inputNumbers.stream().map(number -> numbers.add(number));
        if(numbers.size() != PERMITTED_LOTTO_LENGTH) {
            throw new IllegalArgumentException("번호 중에 중복 번호가 있습니다.");
        }
    }

    public void validateNumbersPermittedRange(List<Integer> inputNumbers) {
        for(int input : inputNumbers) {
            if(input < MIN_LOTTO_NUMBER || input > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("로또의 범위는 1~45입니다.");
            }
        }
    }
    // 밑에 예외가 있음
    public void validateBonusNumberIsNumber(String inputBonusNumber) {
        if(!inputBonusNumber.matches(ONLY_NUMBER_REGEX)) {
            throw new IllegalArgumentException("보너스 번호는 한 개의 숫자만 입력 가능합니다.");
        }
    }

    public void

}
