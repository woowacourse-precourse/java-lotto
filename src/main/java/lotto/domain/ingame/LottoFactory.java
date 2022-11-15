package lotto.domain.ingame;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    public static LuckyNumbers createLuckyNumbers(List<Integer> luckyBalls, int bonus) {
        return new LuckyNumbers(luckyBalls, bonus);
    }

    public static List<Lotto> createLotto(int tickets) {

        List<Lotto> userLotto = new ArrayList<>();

        for (int i = 0; i < tickets; i++) {
            userLotto.add(createSingleLotto());
        }

        return userLotto;
    }

    private static List<Integer> generateRandomNumbers() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    private static Lotto createSingleLotto() {
        return new Lotto(generateRandomNumbers());
    }
}
