package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Validation;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private final int money;
    private final List<Lotto> lottoes;

    public Purchase(String input) {
        Validation.money(input);
        this.money = Integer.parseInt(input);
        this.lottoes = buyLottoes(money);
    }

    private List<Lotto> buyLottoes(int money) {

        return lottoes;
    }

    public int getLottoAmount(int money) {
        return money / 1000;
    }
}
