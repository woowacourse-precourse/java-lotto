package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Customer {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> purchaseLottos(int money) {
        return IntStream.range(0, getLottoCount(money))
                .mapToObj(index -> purchaseLotto())
                .collect(Collectors.toList());
    }

    public int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private Lotto purchaseLotto() {
        return new Lotto(generateLottoNumber());
    }

    private List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
