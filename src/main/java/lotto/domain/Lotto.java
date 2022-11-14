package lotto.domain;

import lotto.utils.Constant;
import lotto.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateIsDistinct(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    public Lotto(String winningNumbers) {
        checkWinningNumber(winningNumbers);
        List<Integer> convertedNumber = convertToList(winningNumbers);
        validateNumberSize(convertedNumber);
        validateIsDistinct(convertedNumber);
        checkNumberInRange(convertedNumber);
        this.numbers = sortLottoNumbers(convertedNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_SIX);
        }
    }

    private void validateIsDistinct(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();

        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_DISTINCT);
        }
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        List<Integer> notImmutableList = new ArrayList<>(numbers);
        Collections.sort(notImmutableList);
        return notImmutableList;
    }

    public void validateDistinctInBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber))
            throw new IllegalArgumentException(ErrorMessage.BONUS_DISTINCT_WINNING_NUMBER);
    }

    public void checkWinningNumber(String input) {
        String[] split = input.split(",");

        boolean result = Arrays.stream(split).allMatch((alphbet) -> alphbet.charAt(0) >= '0' && alphbet.charAt(0) <= '9');
        if (!result)
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INPUT_MUST_NUMBER);
    }

    public List<Integer> convertToList(String numbers) {
        String[] split = numbers.split(",");
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            result.add(Integer.parseInt(split[i]));
        }

        return result;
    }

    public void checkNumberInRange(List<Integer> numbers) {
        boolean inRange = numbers.stream().allMatch(number -> number >= 1 && number <= 45);

        if (inRange == false)
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IN_RANGE);
    }
}
