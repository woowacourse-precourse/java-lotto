package lotto.logic;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.object.Lotto;

import java.util.ArrayList;
import java.util.List;

public class CalcLottoNumber {

    public static List<Lotto> getLottos(Long amount) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < amount; i++) {
            lottos.add(getLotto());
        }

        return lottos;
    }

    private static Lotto getLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

         return new Lotto(numbers);
    }

}
