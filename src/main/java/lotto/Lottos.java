package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public ArrayList<Lotto> getLottos() {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            lottos.add(lotto);
        }
        return lottos;
    }
}
