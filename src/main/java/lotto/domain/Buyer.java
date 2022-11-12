package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
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

    public void buyLottos() {

    }
}
