package lotto.domain;

import java.util.List;

public class Buyer {

    private List<Lotto> lottos;
    public static Buyer newInstance() {
        return new Buyer();
    }

    public void selectLotto(Lotto lotto) {
        if (hasSameWith(lotto)) {
            lottos.add(lotto);
        }
    }
    public void buyLotto(int number) {
        while (lottos.size()<number) {
            selectLotto(Lotto.generateLotto());
        }
    }
    private boolean hasSameWith(Lotto newLotto) {
        return lottos.stream()
                .anyMatch(lotto -> equals(newLotto));
    }
}
