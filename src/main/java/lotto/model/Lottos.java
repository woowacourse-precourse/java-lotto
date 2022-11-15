package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.NumberGenerator;

public class Lottos {
    private List<Lotto> lottos;
    int count;
    NumberGenerator numberGenerator;

    public Lottos(int count) {
        this.count = count;
        numberGenerator = new NumberGenerator();
        lottos = new ArrayList<>(this.count);
        for (int i = 0; i < this.count; i++) {
            lottos.add(i, new Lotto(numberGenerator.createLottoNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCount() {
        return count;
    }
}
