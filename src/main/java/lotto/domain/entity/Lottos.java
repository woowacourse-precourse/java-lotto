package lotto.domain.entity;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.util.RandomNumberGenerator;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(int amountOfLotto) {
        lottos = new ArrayList<>();
        settingLottos(amountOfLotto);
    }

    private void settingLottos(int amountOfLotto) {
        for (int i = 0; i < amountOfLotto; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }
    }

    public static Lottos from(int amountOfLotto) {
        return new Lottos(amountOfLotto);
    }

}
