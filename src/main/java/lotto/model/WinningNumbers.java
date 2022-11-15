package lotto.model;

import lotto.enums.Error;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static List<Integer> winningNumbers;
    private static int bonusNumber;
    private static final int MAX_NUM = 45;
    private static final int MIN_NUM = 1;
    private static final int NUM_SIZE = 6;

    public WinningNumbers(String numbers, String bonus) {
        setWinningNumbers(numbers, bonus);
    }
    public void setWinningNumbers(String numbers, String bonus) {
        winningNumbers = splitNumbers(numbers);
        bonusNumber = isBonusValid(bonus);
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
            isNumInRange(num);
        }
    }
    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE.getError());
        }
    }
    private void isNumInRange(int num) {
        if((num > MAX_NUM) || (num < MIN_NUM)) {
            throw new IllegalArgumentException(Error.LOTTO_RANGE.getError());
        }
    }
    private Integer isBonusValid(String number) {
        int num;
        try{
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.LOTTO_NUMERIC.getError());
        }

        isNumInRange(num);
        if(winningNumbers.contains(num)) {
            throw new IllegalArgumentException(Error.DUPLICATE.getError());
        }
        return num;
    }
    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}
