package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    private Integer bonusNumber;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoNumber() {
        return this.numbers;
    }

    public Integer getLottoBonusNumber() {
        return this.bonusNumber;
    }
}
