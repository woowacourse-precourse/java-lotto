package lotto.domain.draw;

import java.util.List;
import lotto.domain.lotto_numbers.Lotto;

public class Purchaser {

    private final List<Lotto> purchasedLottos;

    public Purchaser(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }
}
