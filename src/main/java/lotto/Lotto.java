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

    // TODO: 추가 기능 구현
    private static List<Integer> createLottoNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        System.out.println(numbers);
        return numbers;
    }

    static List<Lotto> createLottos(int cnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            Lotto lotto = new Lotto(createLottoNum());
            lottos.add(lotto);
        }
        return lottos;
    }

    public enum Rank {
        FIRST(6, false, 2000000000),
        SECOND(5, true, 30000000),
        THIRD(5, false, 1500000),
        FOURTH(4, false, 50000),
        FIFTH(3, false, 5000);

        private final int sameCount;
        private final boolean isBonus;
        private final int prize;

        Rank(int sameCount, boolean isBonus, int prize) {
            this.sameCount = sameCount;
            this.isBonus = isBonus;
            this.prize = prize;
        }

        public int getSameCount() {
            return sameCount;
        }

        public boolean getIsBonus() {
            return isBonus;
        }

        public long getPrize() {
            return prize;
        }
    }
}
