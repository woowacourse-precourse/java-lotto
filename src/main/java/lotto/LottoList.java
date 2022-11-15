package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottos;

    public LottoList(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    private void validate(List<Lotto> lottos) {
        if (lottos.size() < 1) {
            throw new IllegalArgumentException("[ERROR] 로또의 개수는 1개 이상입니다.");
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getSize() {
        return lottos.size();
    }
}
