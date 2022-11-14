package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private static final int PRICE = 1000;
    private static final String MULTIPLE_ERROR = "[ERROR] 구입금액이 가격으로 나누어 떨어지지 않습니다";

    public List<Lotto> buyLottos(int money) {
        isMultipleOfPrice(money);
        int amount = money / PRICE;
        System.out.printf("%d개를 구매했습니다.%n", amount);
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < amount) {
            Lotto lotto = createLotto();
            lotto.printNumbers();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private static void isMultipleOfPrice(int money) {
        if (money % PRICE != 0) {
            System.out.println(MULTIPLE_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
