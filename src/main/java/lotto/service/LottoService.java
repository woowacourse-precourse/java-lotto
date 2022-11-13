package lotto.service;

import lotto.model.Lottos;

public class LottoService {
    public Lottos purchaseLottos(String money) {
        return Lottos.purchaseLottos(Integer.parseInt(money));
    }
}
