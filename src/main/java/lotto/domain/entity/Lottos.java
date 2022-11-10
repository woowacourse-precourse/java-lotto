package lotto.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(int amountOfLotto) {
        lottos = new ArrayList<>();
        for (int i = 0; i < amountOfLotto; i++) {

        }
    }

    public static Lottos from(int amountOfLotto) {
        return new Lottos(amountOfLotto);
    }

}
