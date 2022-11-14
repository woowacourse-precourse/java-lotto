package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
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

    public void buyLotto() {
        String lottoAmount = Console.readLine();
        validatesLottoAmount(lottoAmount);
        generateLotto(Integer.parseInt(lottoAmount));
    }

    private void generateLotto(int amount) {
        int count = countOfBuyLottos(amount);
        IntStream.range(1, count).forEach(value -> lottos.add(Lotto.create()));
        OutputView.printPurchase(count, lottos);
    }

    private int countOfBuyLottos(int amount) {
        return (amount / DIVIDING_NUMBER) + 1;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
