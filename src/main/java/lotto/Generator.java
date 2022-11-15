package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {
    static final int LOTTO_PRICE = 1000;

    public static List<Lotto> generate(int payment) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < countLottos(payment); count++) {
            List<Integer> lottoNumbers = new ArrayList<>(pickLottoNumbers());
            Lotto newLotto = new Lotto(orderNumbers(lottoNumbers));
            lottos.add(newLotto);
        }
        return lottos;
    }

    public static int countLottos(int payment) {
        return payment / LOTTO_PRICE;
    }

    public static List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Integer> orderNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}