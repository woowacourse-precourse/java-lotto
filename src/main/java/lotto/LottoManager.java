package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private List<Lotto> lotties;
    private int buyingMoney;

    public LottoManager(int buyingMoney) {
        this.buyingMoney = buyingMoney;
        lotties = new ArrayList<>();
        for (int i = 0; i < buyingMoney / 1000; i++) {
            lotties.add(generateRandomLotto());
        }
    }

    private Lotto generateRandomLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
