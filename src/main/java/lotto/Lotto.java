package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Utils.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public String toStringLotto() {
        StringBuilder lotto = new StringBuilder("[");
        for (int n : this.numbers) {
            lotto.append(String.valueOf(n)).append(", ");
        }
        lotto = new StringBuilder(lotto.substring(0, lotto.length() - 2) + "]");
        return lotto.toString();
    }

    public int getSameNumberCount(List<Integer> winning) {
        return (int) numbers.stream().filter(winning::contains).count();
    }
}
