package lotto.service;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    static int count;
    static int bonus;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            //숫자가 6개가 아님 exception
        }
    }

    // TODO: 추가 기능 구현
    private void validateUnique(List<Integer> numbers) {
        for(int i:numbers) {
            validateLoop(i, numbers);
        }
    }
    private void validateLoop(int i, List<Integer> numbers) {
        for(int j:numbers) {
            isUnique(i, j, numbers);
        }
    }
    private void isUnique(int i, int j, List<Integer> numbers) {
        if(numbers.get(i).equals(numbers.get(j))) {
            //중복 exception
        }
    }

    public int getCount(int count) {
        Lotto.count = count;
        return count;
    }

    public void LottoCount1(List<Integer> numbers, List<Integer> input, int j) {
        for(j=0; j<6; j++) {
            LottoCount2(numbers, input, j);
        }
        if(bonus == numbers.get(j)) {
            bonus =1;
        }
    }
    public void LottoCount2(List<Integer> numbers, List<Integer> input, int j) {
        for(int i =0; i <6; i++) {
            isEquals(numbers, input, i, j);
        }
    }

    public void isEquals(List<Integer> numbers, List<Integer> input, int i, int j) {
        if(input.get(i).equals(numbers.get(j))) {
            count++;
        }
    }
}
