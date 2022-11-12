package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();
    private Integer numberOfLottos = 0;

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Integer getNumberOfLottos() {
        return numberOfLottos;
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
        this.numberOfLottos += 1;
    }
}
