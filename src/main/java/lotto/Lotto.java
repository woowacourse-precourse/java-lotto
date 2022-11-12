package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

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
    public static List<Integer> create() {
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    // TODO: 추가 기능 구현
}
