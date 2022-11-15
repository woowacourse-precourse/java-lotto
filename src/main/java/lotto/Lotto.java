package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConst.LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void setLottoBonusNumber(int number) {
        if (number < LottoConst.START_RANGE || number > LottoConst.END_RANGE) {
            throw new IllegalArgumentException();
        }

        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }

        numbers.add(number);
    }

    public int getMatchCountWithLotto(List<Integer> purchase) {
        return (int) purchase.stream()
                .filter(number -> numbers.contains(number))
                .count();
    }
}
