package lotto.domain;

import static lotto.validator.LottoNumberValidator.validateExistDuplicateNumber;
import static lotto.validator.LottoNumberValidator.validateRangeOfNumber;
import static lotto.validator.UserInputValidator.validateWinningLottoNumberComplyWithRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Constants;
import lotto.constant.LottoNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRangeOfNumber(numbers);
        validateExistDuplicateNumber(numbers);

        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    public Lotto(String userInput) {
        validateWinningLottoNumberComplyWithRule(userInput);
        List<Integer> numbers = convertToNumbers(userInput);
        validate(numbers);
        validateRangeOfNumber(numbers);
        validateExistDuplicateNumber(numbers);

        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.NUMBER_OF_LOTTO_NUMBERS.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }

    private List<Integer> convertToNumbers(String str) {
        return Arrays.stream(str.split(Constants.WINNING_LOTTO_NUMBER_INPUT_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
