package lotto;

import java.util.HashMap;
import java.util.List;

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

    public Integer checkWin(List<Integer> winNumbers) {
        HashMap<Integer, Integer> lottoMap = new HashMap<>();
        Integer count = 0;
        for (Integer number : numbers) {
            lottoMap.put(number, 0);
        }
        for (Integer winNumber : winNumbers) {
            if (lottoMap.containsKey(winNumber)) {
                count += 1;
            }
        }

        return count;
    }

    public boolean checkBonusNumber(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
