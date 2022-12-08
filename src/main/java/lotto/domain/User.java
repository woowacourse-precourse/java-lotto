package lotto.domain;

import java.util.List;

public class User {
    private Money money;
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public User(Money money, List<Integer> winningNumber, Integer bonusNumber) {
        this.money = money;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public Money getMoney() {
        return money;
    }
}
