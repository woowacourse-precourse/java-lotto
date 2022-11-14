package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.util.ErrorMessage.DUPLICATED_NUMBER;
import static lotto.util.ErrorMessage.NOT_DIVIDED_BY_THOUSAND;
import static lotto.util.LottoCode.*;

public class Validation {
    private static final String REGEX_NOT_NUMBER = "[^\\d]";

    public void validateMoneyInput(String input) {
        validateIsNumberInput(input);

        int money = Integer.parseInt(input);
        validateDivedThousand(money);
    }

    private void validateDivedThousand(int money) {
        boolean match = (money % LOTTO_PRICE.getCode()) != 0;
        if (match) {
            System.out.println(NOT_DIVIDED_BY_THOUSAND.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void validateResultNumberInput(String result) {
        List<Integer> numbers = separateNumbers(result);

        validateOutOfRange(numbers);

        validateDuplicate(numbers);
    }

    public void validateIsNumberInput(String bonus) {
        validateByRegex(REGEX_NOT_NUMBER, bonus);
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
            System.out.println();
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

    private void validateOutOfRange(List<Integer> numbers) {
        numbers.forEach(this::validateOutOfRange);
    }

    private void validateOutOfRange(Integer number) {
        boolean match = (number >= MIN_LOTTO_NUMBER.getCode()) && (number <= MAX_LOTTO_NUMBER.getCode());

        if (match) {
            System.out.println(DUPLICATED_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        boolean match = numbers.size() != numbers.stream().distinct().count();

        if (match) {
            System.out.println(DUPLICATED_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers, Integer bonusNumber) {
        validateDuplicate(numbers);
        boolean match = numbers.contains(bonusNumber);
        if (match) {
            System.out.println(DUPLICATED_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> separateNumbers(String result) {
        try {
            return Arrays.stream(result.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
