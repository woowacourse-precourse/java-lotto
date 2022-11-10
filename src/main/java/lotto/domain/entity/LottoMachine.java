package lotto.domain.entity;

import java.util.List;

public class LottoMachine {

    private List<Integer> lottoNumbers;
    private int bonusNumber;
    private Money money;

    private LottoMachine(List<Integer> lottoNumbers, int bonusNumber, int money) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
        this.money = Money.from(money);
    }

    public static LottoMachine of(List<Integer> lottoNumbers, int bonusNumber, int money) {
        return new LottoMachine(lottoNumbers, bonusNumber, money);
    }
}
