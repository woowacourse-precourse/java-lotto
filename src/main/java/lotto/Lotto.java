package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Output.showError(Error.WINNING_NUMS_LENGTH);
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        int originalSize = numbers.size();
        Set<Integer> set = new HashSet<>(numbers);
        if(originalSize != set.size()){
            Output.showError(Error.DUPLICATED_NUM);
            throw new IllegalArgumentException();
        }
    }

    public static Lotto create() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNums = new ArrayList(randoms);
        Collections.sort(lottoNums);
        return new Lotto(lottoNums);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Score getScore(List<Integer> winningNumbers, int bonusNumber) {
        int[] output = new int[2];
        Set<Integer> nums = Converter.listToSet(numbers);
        Set<Integer> winNums = Converter.listToSet(winningNumbers);
        nums.retainAll(winNums);
        output[0] = nums.size();
        if(numbers.contains(bonusNumber))
            output[1] = 1;
        return getScoreEnum(output);
    }

    public Score getScoreEnum(int[] score) {
        if (score[0] == 3) {
            return Score.FIFTH;
        }
        if (score[0] == 4) {
            return Score.FOURTH;
        }
        if (score[0] == 5) {
            if (score[1] == 1) {
                return Score.SECOND;
            }
            return Score.THIRD;
        }
        if (score[0] == 6) {
            return Score.FIRST;
        }
        return Score.NOTHING;
    }
}
