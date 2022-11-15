package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buyer {
    private int money;
    private List<Lotto> lottos;

    public Buyer() {
        lottos = new ArrayList<Lotto>();
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public void buyLottos(int lottoCount) {
        NumberGenerator numberGenerator = new NumberGenerator();

        for (int index = 0; index < lottoCount; index++) {
            List<Integer> numbers = new ArrayList<Integer>(numberGenerator.createLottoNumbers());
            Lotto lotto = new Lotto(numbers);
            sortLotto(lotto.getNumbers());
            lottos.add(lotto);
        }

    }

    public List<List<Integer>> getLottos() {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int index = 0; index < lottos.size(); index++) {
            Lotto lotto = lottos.get(index);
            result.add(lotto.getNumbers());
        }

        return result;
    }

    public void sortLotto(List<Integer> lotto) {
        Collections.sort(lotto);
    }
}
