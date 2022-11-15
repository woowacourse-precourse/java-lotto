package lotto.model.lotto;

import java.util.*;

public class Lotto {
    private static final int LOTTO_NUMBER_AMOUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 잘못된 개수를 입력하였습니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LOTTO_NUMBER_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또번호를 입력하였습니다.");
        }
    }

    public List<Integer> getNumbers(){
        return new ArrayList<>(numbers);
    }
}
