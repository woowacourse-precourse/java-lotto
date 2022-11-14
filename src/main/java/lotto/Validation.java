package lotto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.util.LottoCode.*;

public class Validation {
    private static final String REGEX_NOT_NUMBER = "[^\\d]";

    public void validateMoney(String input) {
        validateByRegex(REGEX_NOT_NUMBER, input);

        int money = Integer.parseInt(input);
        if ((money % LOTTO_PRICE.getCode()) != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateByRegex(String Regex, String input) {
        Pattern pattern = Pattern.compile(Regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateBasicNumber(List<Integer> numbers) {
        if (numbers.size() != COUNT_LOTTO_NUMBER.getCode()) {
            throw new IllegalArgumentException();
        }

        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }

        if (isOutOfRangeNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }

        if (isDuplicate(numbers, bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRangeNumbers(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(Integer number) {
        return (number < MIN_LOTTO_NUMBER.getCode()) || (number > MAX_LOTTO_NUMBER.getCode());
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private boolean isDuplicate(List<Integer> numbers, Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
