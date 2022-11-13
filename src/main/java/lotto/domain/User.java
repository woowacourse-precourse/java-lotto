package lotto.domain;

import java.util.List;

public class User {
    private final int money;
    private List<Integer> numbers;
    private int bonusNumber;

    public User(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
