package lotto.domain;

import lotto.Constant;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        check_NotEqualSize(numbers);
        check_Duplicate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void check_NotEqualSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_CNT.getNum()) {
            throw new IllegalArgumentException("[ERROR] 랜덤한 로또의 번호의 크기가 정해진 개수만큼 존재하지 않습니다.");
        }
    }
    private void check_Duplicate(List<Integer> numbers) {
        HashSet set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 랜덤한 로또의 번호들이 서로 겹치는 것이 존재합니다.");
        }
    }
}