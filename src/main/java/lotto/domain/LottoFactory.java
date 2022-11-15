package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    private Numbers numbers;

    public LottoFactory(Numbers numbers) {
        this.numbers = numbers;
    }

    public List<Lotto> generateLottos(Money money) {
        int amount = money.getAmount();
        List<Lotto> lottos = new ArrayList<>(amount);

        while (lottos.size() < amount) {
            Lotto lotto = new Lotto(numbers.generate());
            addLotto(lotto, lottos);
        }

        return Collections.unmodifiableList(lottos);
    }

    private void addLotto(Lotto lotto, List<Lotto> lottos) {
        if (!lottos.contains(lotto)) {
            lottos.add(lotto);
        }
    }
}
