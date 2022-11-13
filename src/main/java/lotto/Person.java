package lotto;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Lotto> lottos;

    private Person(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Person from (long principal) {
        long size = principal / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < size; i++) {
            lottos.add(Lotto.createLotto());
        }
        return new Person(lottos);
    }
}
