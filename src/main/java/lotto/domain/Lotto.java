package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Utils;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Utils.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public String toStringLotto() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        StringBuilder lotto = new StringBuilder("[");
        for (int n : sortedNumbers) {
            lotto.append(String.valueOf(n)).append(", ");
        }
        lotto = new StringBuilder(lotto.substring(0, lotto.length() - 2) + "]");
        return lotto.toString();
    }

    public int getMatchNumberCount(List<Integer> winning) {
        return (int) numbers.stream().filter(winning::contains).count();
    }

    public boolean haveBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
