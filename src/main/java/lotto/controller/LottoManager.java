package lotto.controller;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.info.Price.SINGLE_PRICE;

public class LottoManager {
    public List<Lotto> getLottoList(int amount) {
        int count = getCountFromAmount(amount);
        List<Lotto> lottos = new ArrayList<>();

        addLottos(lottos, count);
        return lottos;
    }

    private int getCountFromAmount(int amount) {
        return amount / SINGLE_PRICE.getPrice();
    }

    private void addLottos(List<Lotto> lottos, int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(LottoMachine.publishLotto());
        }
    }
}
