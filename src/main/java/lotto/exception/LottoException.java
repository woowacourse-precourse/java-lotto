package lotto.exception;

import static lotto.util.LottoUtil.bonusNumberParser;
import static lotto.util.LottoUtil.lottoNumbersParser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoException {

    private final static int PERMITTED_LOTTO_LENGTH = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private static final String ONLY_NUMBER_REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$+";

    public void validateLottoNumbers(List<Integer> numbers) {
        validateLottoNumbersLength(numbers);
        validateOverlapNumbers(numbers);
        validateNumbersPermittedRange(numbers);
    }

    public void validateBonusNumbers(String inputNumbers, String inputBonusNumber) {
        validateBonusNumberIsNumber(inputBonusNumber);
        validateBonusNumberPermittedRange(bonusNumberParser(inputBonusNumber));
        validateBonusNumberOverlapNumbers(lottoNumbersParser(inputNumbers), bonusNumberParser(inputBonusNumber));
    }

    public void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != PERMITTED_LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 6개 입력해주세요.");
        }
    }

    public void validateOverlapNumbers(List<Integer> inputNumbers) {
        Set<Integer> numbers = new HashSet<>();
        inputNumbers.stream().map(number -> numbers.add(number)).collect(Collectors.toList());
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
