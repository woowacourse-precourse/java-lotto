package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.constance.InputExceptionConstance.*;
import static lotto.exception.InputException.*;

public class Buyer {
    private final List<Lotto> lottos;

    public Buyer() {
        lottos = new ArrayList<>();
    }

    public int buyLotto(String lottoAmount) {
        validatesLottoAmount(lottoAmount);
        generateLotto(Integer.parseInt(lottoAmount));
        return Integer.parseInt(lottoAmount);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private void generateLotto(int amount) {
        int count = countOfBuyLottos(amount);
        IntStream.range(1, count + 1).forEach(value -> lottos.add(Lotto.create()));
        OutputView.printPurchase(count, lottos);
    }

    private int countOfBuyLottos(int amount) {
        return (amount / DIVIDING_NUMBER);
    }
}
