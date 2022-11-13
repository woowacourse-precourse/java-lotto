package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator extends Kiosk {
    public static List<Lotto> generate(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int lottoNumber = 0; lottoNumber < numberOfLottos; lottoNumber++) {
            List<Integer> lottoNumbers = new ArrayList<>(pickLottoNumbers());
            lottos.add(new Lotto(orderNumbers(lottoNumbers)));
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