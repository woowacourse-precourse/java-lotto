package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Lotto> lottos;
    private LottoGenerator lottoGenerator;
    public User() {
        this.lottos = new ArrayList<>();
        this.lottoGenerator = new LottoGenerator();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void buyLotto(int price) {
        while(price >= 1000) {
            lottos.add(lottoGenerator.publish());
            price -= 1000;
        }
    }

    public List<Integer> getWinningHistory() {
        return null;
    }

    public float getYield() {
        return 0.0f;
    }

}
