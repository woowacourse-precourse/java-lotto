package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation.validateInputLength(numbers);
        Validation.validateDuplicate(numbers);
        this.numbers = numbers;
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
        int cnt = (int) purchase.stream()
                .filter(number -> numbers.contains(number))
                .count();
        if (cnt == LottoConst.LOTTO_LENGTH) {
            cnt += 1;
        }
        if (cnt == LottoConst.LOTTO_LENGTH - 1 && purchase.contains(numbers.get(LottoConst.LOTTO_LENGTH))) {
            cnt += 1;
        }
        return cnt;
    }
}
