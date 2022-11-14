package lotto.vo;

import java.util.ArrayList;
import java.util.List;

public class LottoOfUser {
    private final List<Lotto> lottos;

    public LottoOfUser() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
