package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.InputException.*;

public class Buyer {
    private final List<Lotto> lottos;

    public Buyer() {
        lottos = new ArrayList<>();
    }

    public int inputLottoAmount() {
        String lottoAmount = Console.readLine();
        validatesLottoAmount(lottoAmount);
        return Integer.parseInt(lottoAmount);
    }

    public void buyLottos(int amount) {
        int count = countOfLottos(amount);
        for(int i=0; i<=count; i++) {
            lottos.add(Lotto.generateLotto());
        }

        OutputView.printPurchase(count);
    }

    private int countOfLottos(int amount) {
        return amount/1000;
    }
}
