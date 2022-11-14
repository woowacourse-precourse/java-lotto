package lotto.domain;

import java.util.List;

public class Buyer {
    private int money;
    private List<List<Integer>> lottos;
    
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
            lottos.add(lotto);
        }
    }

    public List<List<Integer>> getLottos() {
        return this.lottos;
    }
}
