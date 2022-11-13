package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> numbers() {
        List<Integer> pickNums = new ArrayList<>();
        pickNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return pickNums;
    }

//    public List<Integer> getNumbers() {
//        return numbers;


    // TODO: 추가 기능 구현





}