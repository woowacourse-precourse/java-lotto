package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static List<Lotto> publishLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        while (count-- > 0){
          Lotto newLotto = new Lotto(RandomNumGenerator.makeUniqueLottoNum());
          lottos.add(newLotto);
        }
        return lottos;
    }
}

