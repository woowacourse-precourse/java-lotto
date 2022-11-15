package lotto.model.resources;

import java.util.List;

import lotto.ExceptionHandle;

public class LottoWin {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_FIRST_NUM = 1;
    private static final int LOTTO_LAST_NUM = 45;

    private final List<Integer> numbers;

    private LottoWin(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static LottoWin of(List<Integer> numbers) {
        return new LottoWin(numbers);
    }

    private void validate(List<Integer> numbers) {
        long count = numbers.stream()
                .filter(i -> i >= LOTTO_FIRST_NUM && i <= LOTTO_LAST_NUM)
                .distinct()
                .count();
        try {
            if (count != LOTTO_SIZE) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionHandle("[ERROR] 로또 당첨 번호는 1과 45 사이의 중복되지 않는 6개의 정수여야 합니다. - Lotto");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
