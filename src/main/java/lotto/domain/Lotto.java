package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.constant.Constants;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;
import lotto.constant.RegularExpression;

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
    private void validateWinningLottoNumberComplyWithRule(String userInput) {
        for (String splitInput : userInput.split(Constants.WINNING_LOTTO_NUMBER_INPUT_SEPARATOR)) {
            if (!Pattern.matches(RegularExpression.ONLY_NUMBER.getRegex(), splitInput)) {
                throw new IllegalArgumentException(
                        ErrorMessage.USER_INPUT_DOES_NOT_COMPLY_WITH_RULE_FOR_WINNING_LOTTO_NUMBER.getMessage()
                );
            }
        }
    }

    private void validateRangeOfNumber(List<Integer> numbers) {
        long outOfRangeCount = numbers.stream()
                .filter(number -> !isInRange(number))
                .count();
        if (outOfRangeCount != 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isInRange(int number) {
        return LottoNumber.START_NUMBER_OF_LOTTO.getNumber() <= number
                && number <= LottoNumber.END_NUMBER_OF_LOTTO.getNumber();
    }

    private void validateExistDuplicateNumber(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.CAN_NOT_EXIST_DUPLICATE_NUMBER_IN_LOTTO.getMessage());
        }
    }

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
