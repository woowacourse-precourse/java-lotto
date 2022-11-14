package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static List<Lotto> generateLottoSet(int counts) {
        List<Lotto> lottos = new ArrayList<>();
        for(int count =0; count < counts; count++) {
            lottos.add(Lotto.generate());
        }
        return lottos;
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        for(int n : numbers) {
            if(n >= 1 && n <= 45) {
                continue;
            }
            throw new IllegalArgumentException("올바르지 않은 로또 번호입니다.");
        }
    }

    // TODO: 추가 기능 구현
}
