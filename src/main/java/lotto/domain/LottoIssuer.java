package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;

public class LottoIssuer {

    public static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public static List<Lotto> generateAllLotto(int amount) {
        int lottoNumber = amount / 1000;
        List<Lotto> lottos = new LinkedList<>();
        for (int i = 0; i < lottoNumber; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

}
