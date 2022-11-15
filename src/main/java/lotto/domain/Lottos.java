package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    // 로또 여러개를 저장하는 기능
    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    // 로또 여러개를 가져오는 기능
    public List<Lotto> getLottos() {
        return lottos;
    }
}
