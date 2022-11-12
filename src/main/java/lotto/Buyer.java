package lotto;

import java.util.List;

public class Buyer {
    private List<Lotto> lottos;

    public Buyer(List<Lotto> lottos) {
        validateForSize(lottos);
        this.lottos = lottos;
    }

    private void validateForSize(List<Lotto> lottos) {
        if (lottos.size() == 0) {
            throw new IllegalArgumentException("[ERROR] 복권은 한장이상 사야됩니다.");
        }
    }
}
