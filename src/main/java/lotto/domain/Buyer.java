package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

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
        int count = countOfLottos(amount);
        for(int i=1; i<=count; i++) {
            lottos.add(Lotto.generateLotto());
        }

        OutputView.printPurchase(count, lottos);
    }

    private int countOfLottos(int amount) {
        return amount/1000;
    }
}
