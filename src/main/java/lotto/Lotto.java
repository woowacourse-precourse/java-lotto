package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final String ERROR_NUMBER_COUNT = "로또 번호는 6개여야 합니다.";
    private static final String ERROR_NUMBER_RANGE = "로또 번호는 1 ~ 45 여야 합니다.";
    private final List<Integer> numbers;
    private static final List<Integer> initLottoNumbers = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            initLottoNumbers.add(i);
        }
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_NUMBER_COUNT);
        }
    }

    public static List<Integer> generateLottoNumbers() {
        Collections.shuffle(initLottoNumbers);
        List<Integer> lottoNumbers = initLottoNumbers.subList(0, 45);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
