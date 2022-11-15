package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateInputLength(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateInputLength(List<Integer> numbers) {
        if (numbers.size() != LottoConst.LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> deletedDuplicate = new HashSet<>(numbers);
        if (deletedDuplicate.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
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
