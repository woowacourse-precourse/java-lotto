package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Lotto> lottos;

    public User() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void buyLotto(int price) {
        return;
    }

    public List<Integer> getWinningHistory() {
        return null;
    }

    public float getYield() {
        return 0.0f;
    }

}
