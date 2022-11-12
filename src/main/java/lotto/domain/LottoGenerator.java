package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static List<Lotto> lottos;
    private final int quantity;

    public LottoGenerator(int money) {
        this.quantity = money / 1000;
    }

    public List<Lotto> generateLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int getQuantity() {
        return quantity;
    }
}
