package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buyer {
    private int money;
    private List<List<Integer>> lottos;
    
    public Buyer() {
        lottos = new ArrayList<List<Integer>>();
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
            List<Integer> lotto = numberGenerator.createLottoNumbers();
            sortLotto(lotto);
            lottos.add(lotto);
        }
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }
    
    public void sortLotto(List<Integer> lotto) {
        Collections.sort(lotto);
    }
}
