package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
