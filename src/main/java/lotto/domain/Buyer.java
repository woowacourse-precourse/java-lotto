package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
        for(int i=0; i<=countOfLottos(amount); i++) {
            lottos.add(Lotto.generateLotto());
        }
    }

    private int countOfLottos(int amount) {
        return amount/1000;
    }
}
