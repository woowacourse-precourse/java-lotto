package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    public static final int PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(int amount) {
        lottos = new ArrayList<>();
        create(amount);
    }

    private void create(int amount) {
        int count = amount / PRICE;
        for (int number = 0; number < count; number++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateNumbers());
            lottos.add(lotto);
        }
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
