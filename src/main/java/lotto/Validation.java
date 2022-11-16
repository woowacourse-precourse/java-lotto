package lotto;

import lotto.util.ResultPrice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.util.ErrorMessage.*;
import static lotto.util.LottoCode.*;

public class Validation {
    private static final String REGEX_NOT_NUMBER = "\\D";

    private static void accept(ResultPrice o) {
        throw new IllegalArgumentException();
    }

    public void validateMoneyInput(String input) {
        validateIsNumberInput(input);

        int money = Integer.parseInt(input);
        validateDivedThousand(money);
    }

    private void validateDivedThousand(int money) {
        boolean match = (money % LOTTO_PRICE.getCode()) != 0;
        if (match) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_THOUSAND.getMessage());
        }
    }

    public void validateResultNumberInput(String result) {
        List<Integer> numbers = separateNumbers(result);

        validateOutOfRange(numbers);

        validateDuplicate(numbers);
    }

    public void validateIsNumberInput(String bonus) {
        Pattern pattern = Pattern.compile(REGEX_NOT_NUMBER);
        Matcher matcher = pattern.matcher(bonus);

        if (matcher.find()) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    public void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        validateOutOfRange(bonusNumber);

        validateDuplicate(numbers, bonusNumber);
    }

    public void validateBasicNumber(List<Integer> numbers) {

        validateCountOfLottoNumbers(numbers);

        validateDuplicate(numbers);

        validateOutOfRange(numbers);
    }

    private void validateCountOfLottoNumbers(List<Integer> numbers) {
        boolean match = numbers.size() != COUNT_LOTTO_NUMBER.getCode();
        if (match) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    private void validateOutOfRange(List<Integer> numbers) {
        numbers.forEach(this::validateOutOfRange);
    }

    private void validateOutOfRange(Integer number) {
        boolean match = !((number >= MIN_LOTTO_NUMBER.getCode()) && (number <= MAX_LOTTO_NUMBER.getCode()));

        if (match) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        boolean match = numbers.size() != numbers.stream().distinct().count();

        if (match) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers, Integer bonusNumber) {
        validateDuplicate(numbers);
        boolean match = numbers.contains(bonusNumber);
        if (match) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }

    private List<Integer> separateNumbers(String result) {
        try {
            return Arrays.stream(result.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }

    public void validateResultPrice(Map<ResultPrice, Integer> result) {
        long match = Arrays.stream(ResultPrice.values())
                .filter(o -> result.get(o) == null)
                .count();
        if (match != 0) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }
}
