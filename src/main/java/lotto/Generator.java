package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {
    public static List<Lotto> generate(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < numberOfLottos; count++) {
            List<Integer> lottoNumbers = new ArrayList<>(pickLottoNumbers());
            Lotto newLotto = new Lotto(orderNumbers(lottoNumbers));
            lottos.add(newLotto);
        }
        return lottos;
    }

    public static List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Integer> orderNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}