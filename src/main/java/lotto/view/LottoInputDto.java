package lotto.view;

import java.util.List;
import lotto.domain.Money;

public class LottoInputDto {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private Money money;

    public LottoInputDto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }
}
