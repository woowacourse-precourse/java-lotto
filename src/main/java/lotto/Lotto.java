package lotto;

import java.util.ArrayList;
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

    // TODO: 추가 기능 구현
    private static List<Integer> createLottoNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    static List<Lotto> createLottos(int cnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            Lotto lotto = new Lotto(createLottoNum());
            lottos.add(lotto);
        }
        return lottos;
    }
}