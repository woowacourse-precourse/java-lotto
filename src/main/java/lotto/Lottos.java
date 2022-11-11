package lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    public Lottos(List<Lotto> lottos) {
        checkSize(lottos);
        this.lottos = lottos;
    }

    private void checkSize(List<Lotto> lottos) {
        if (lottos.size() < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 개수가 1 미만일 수 없어요.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
