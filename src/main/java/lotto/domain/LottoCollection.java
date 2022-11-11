package lotto.domain;

import java.util.List;

public class LottoCollection {
    private final List<Lotto> lottos;
    private final String SEPARATOR = "\n";

    public LottoCollection(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString()).append(SEPARATOR);
        }

        return sb.toString();
    }
    public static LottoCollection of(List<Lotto> lottos) {
        return new LottoCollection(lottos);
    }
}
