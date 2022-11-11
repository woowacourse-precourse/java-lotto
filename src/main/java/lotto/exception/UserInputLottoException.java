package lotto.exception;

import static lotto.util.LottoUtil.bonusNumberParser;
import static lotto.util.LottoUtil.lottoNumbersParser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputLottoException {

    private final static int PERMITTED_LOTTO_LENGTH = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private static final String ONLY_NUMBER_REGEX = "[1-45]+";

    public void validateLotto(String inputNumbers, String inputBonusNumber) {
        validateLottoNumbersLength(inputNumbers);
        validateOverlapNumbers(lottoNumbersParser(inputNumbers));
        validateNumbersPermittedRange(lottoNumbersParser(inputNumbers));
        validateBonusNumberIsNumber(inputBonusNumber);
        validateBonusNumberPermittedRange(bonusNumberParser(inputBonusNumber));
        validateBonusNumberOverlapNumbers(lottoNumbersParser(inputNumbers), bonusNumberParser(inputBonusNumber));

    }

    public void validateLottoNumbersLength(String numbers) {
        if (numbers.replace(",", "").length() != PERMITTED_LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateOverlapNumbers(List<Integer> inputNumbers) {
        Set<Integer> numbers = new HashSet<>();
        inputNumbers.stream().map(number -> numbers.add(number));
        if (numbers.size() != PERMITTED_LOTTO_LENGTH) {
            throw new IllegalArgumentException("번호 중에 중복 번호가 있습니다.");
        }
    }

    public void validateNumbersPermittedRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("로또의 범위는 1~45입니다.");
            }
        }
    }

    public void validateBonusNumberIsNumber(String bonusNumber) {
        if (!bonusNumber.matches(ONLY_NUMBER_REGEX)) {
            throw new IllegalArgumentException("보너스 번호는 한 개의 숫자만 입력 가능합니다.");
        }
    }

    public void validateBonusNumberPermittedRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또의 범위는 1~45입니다.");
        }
    }

    public void validateBonusNumberOverlapNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 중복됩니다.");
        }
    }

}
