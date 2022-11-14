package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person {
    private List<Lotto> lottos = new ArrayList<>();
    private int purchaseAmount = 0;

    public void buyLottos() {
        purchaseAmount = Input.inputPurchaseAmount();
        for (int i = 0; i < purchaseAmount; i += Game.lottoPice) {
            lottos.add(new Lotto(createRandomLottoNum()));
        }
    }

    private List<Integer> createRandomLottoNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
