package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static lotto.exception.InputException.*;

public class Buyer {
    private final List<Lotto> lottos;

    public Buyer() {
        lottos = new ArrayList<>();
    }

    public void buyLotto() {
        String lottoAmount = Console.readLine();
        validatesLottoAmount(lottoAmount);
        createLottos(Integer.parseInt(lottoAmount));
    }

    public void createLottos(int amount) {
        int count = countOfBuyLottos(amount);
        IntStream.range(1, count).forEach(value -> lottos.add(Lotto.generateLotto()));
        OutputView.printPurchase(count, lottos);
    }

    private int countOfBuyLottos(int amount) {
        return (amount / 1000) + 1;
    }
}
