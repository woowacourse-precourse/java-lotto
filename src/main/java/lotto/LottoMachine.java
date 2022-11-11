package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> generateLottos(int money) {
        return IntStream.range(0, getLottoCount(money))
                .mapToObj(index -> generateLotto())
                .collect(Collectors.toList());
    }

    public int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private Lotto generateLotto() {
        return new Lotto(generateLottoNumber());
    }

    private List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
