package lotto.model;

import lotto.enums.Error;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static List<Integer> winningNumbers;
    private static final int MAX_NUM = 45;
    private static final int MIN_NUM = 1;
    private static final int NUM_SIZE = 6;

    public void setWinningNumbers() {
        String input = InputView.getWinningNumbers();
        winningNumbers = splitNumbers(input);
    }
    private List<Integer> splitNumbers(String input) {
        List<String> winningNumSplit = List.of(input.split(","));
        List<Integer> newNumbers = new ArrayList<>();
        for(String num: winningNumSplit) {
            try{
                newNumbers.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Error.LOTTO_NUMERIC.getError());
            }
        }

        isNumbersValid(newNumbers);
        isDuplicate(newNumbers);
        return newNumbers;
    }
    private void isNumbersValid(List<Integer> numbers) {
        if(numbers.size() != NUM_SIZE) throw new IllegalArgumentException(Error.SIZE.getError());

        for(Integer num: numbers) {
            if((num > MAX_NUM) || (num < MIN_NUM)) {
                throw new IllegalArgumentException(Error.LOTTO_RANGE.getError());
            }
        }
    }
    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE.getError());
        }
    }
}
