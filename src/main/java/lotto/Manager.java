package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class Manager {
    private List<Lotto> lottoTable = new ArrayList<>();

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int getAmount(int won) {
        if (won % Lotto.PRICE != 0 || won == 0) {
            throw new IllegalArgumentException();
        }
        return won / Lotto.PRICE;
    }

    public void purchaseLotto(int amount){
        for(int i = 0; i < amount; i++){
            Lotto lotto = new Lotto(getRandomNumbers());
            lottoTable.add(lotto);
        }
    }
}
