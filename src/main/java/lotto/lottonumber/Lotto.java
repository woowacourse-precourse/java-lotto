package lotto.lottonumber;

import java.util.List;

import static java.util.Collections.sort;

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

    /**
     * 일바 로또 번호 6개를 오름차순으로 정렬합니다.
     */
    public void sortLottoNumbers() {
        sort(numbers);
    }
}
