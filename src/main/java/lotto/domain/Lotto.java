package lotto.domain;

import static lotto.view.OutputView.printErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isSixNumbers(numbers);
        isDuplicated(numbers);
        isInRange(numbers);
    }

    // TODO: 추가 기능 구현

    private void isSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            printErrorMessage("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicated(List<Integer> numbers) {
        HashSet<Integer> NOT_DUPLICATED_NUMBERS = new HashSet<>();
        for (int i : numbers) {
            NOT_DUPLICATED_NUMBERS.add(i);
        }
        if (NOT_DUPLICATED_NUMBERS.size() != 6) {
            printErrorMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void isInRange(List<Integer> numbers) {
        for (int i : numbers) {
            if (i < 1 || i > 45) {
                printErrorMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public LottoRanking checkWinningResult(List<Integer> winningNumbers, Number bonusNumber) {
        int count = 0;
        for (int i : this.lottoNumbers()) {
            if (isContain(i, winningNumbers)) {
                count++;
            }
        }
        return LottoRanking.findRank(count, numbers.contains(bonusNumber));
    }

    public boolean isContain(int i, List<Integer> numbers) {
        if (numbers.contains(i)) {
            return true;
        }
        return false;
    }

    public List<Integer> lottoNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

}
