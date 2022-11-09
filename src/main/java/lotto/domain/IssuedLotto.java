package lotto.domain;

import java.util.List;

public class IssuedLotto {
    private final List<Lotto> lottos;

    public IssuedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getTotalCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append("\n");
        }
        return sb.toString();
    }
}
