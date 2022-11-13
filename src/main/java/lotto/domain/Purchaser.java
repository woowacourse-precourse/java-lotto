package lotto.domain;

import lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Purchaser {
    private int money;
    private int numberOfLotto;
    private List<Lotto> lottos;

    public Purchaser(int money) {
        this.money = money;
        this.numberOfLotto = computeNumberOfLotto(money);
        lottos = new ArrayList<>();
    }

    public void generateLotto() {
        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(new Lotto(LottoGenerator.getLottoNumbers()));
        }
    }

    private int computeNumberOfLotto(int money) {
        return money / 1000;
    }

}