package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static final int LOTTO_PRICE= 1000;

    public List<Lotto> buy(int money) {
        List<Lotto> buyLotto = new ArrayList<>();
        int numberOfLotto = money / LOTTO_PRICE;
        for (int i = 0; i < numberOfLotto; i++) {
            buyLotto.add(new Lotto(generateNumber()));
        }
        return buyLotto;
    }

    private List<Integer> generateNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
