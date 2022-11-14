package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generateLottos(int paidMoney) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoQuantity = paidMoney / 1000;

        for (int index = 0; index < lottoQuantity; index++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            sortNumbers(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private static void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
