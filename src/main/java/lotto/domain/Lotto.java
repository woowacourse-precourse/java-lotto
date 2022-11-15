package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    static final int numberMinRage = 1;
    static final int numberMaxRage = 45;
    static final int numberCount = 6;
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
    static List<Lotto> creatLottoNumbers(int lottoCount) {
        List<Lotto> purchaseLotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(numberMinRage, numberMaxRage, numberCount);
            purchaseLotto.add(new Lotto(lotto));
        }

        return purchaseLotto;
    }
}
