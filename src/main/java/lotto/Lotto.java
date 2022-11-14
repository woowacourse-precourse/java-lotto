package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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

    // TODO: 추가 기능 구현
    public List<Integer>[] drawLottoNumbers(int lottoCount) {
        List<Integer>[] lottoNumbers = new ArrayList[lottoCount];
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers[i] = new ArrayList<>();
            lottoNumbers[i] = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers[i]);
        }
        return lottoNumbers;
    }
}
