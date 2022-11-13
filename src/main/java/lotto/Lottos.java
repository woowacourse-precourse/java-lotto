package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Money money) {
        lottos = new ArrayList<>();
        createLotto(money);
    }

    private void createLotto(Money money) {
        long count = money.countPurchasable(Lotto.PRICE);
        for (long number = 0; number < count; number++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateNumbers());
            lottos.add(lotto);
        }
    }

    public long getCount() {
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
