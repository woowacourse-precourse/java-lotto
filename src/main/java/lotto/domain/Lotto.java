package lotto.domain;

import lotto.constant.Constant;
import lotto.utils.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation.validateNumberSize(numbers);
        Validation.validateIsDistinct(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    public Lotto(String winningNumbers) {
        Validation.validateCheckNumeric(winningNumbers, Constant.SPLIT_FOR_WINNING_NUMBER);
        List<Integer> convertedNumber = convertToList(winningNumbers);
        Validation.validateNumberSize(convertedNumber);
        Validation.validateIsDistinct(convertedNumber);
        Validation.validNumberInRange(convertedNumber);
        this.numbers = sortLottoNumbers(convertedNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        List<Integer> notImmutableList = new ArrayList<>(numbers);
        Collections.sort(notImmutableList);
        return notImmutableList;
    }

    public List<Integer> convertToList(String numbers) {
        String[] split = numbers.split(Constant.SPLIT_FOR_WINNING_NUMBER);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            result.add(Integer.parseInt(split[i]));
        }

        return result;
    }
}
