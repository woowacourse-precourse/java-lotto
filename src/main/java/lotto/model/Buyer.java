package lotto.model;

import java.util.List;
import lotto.util.Validator;

public class Buyer {
    private int money;
    private List<Integer> numbers;
    private int bonusNumber;
    private Validator validator = new Validator();
    
    public void payMoney(int money) {
        validator.validateUnit(money);
        this.money = money;
    }

    public void buyLottor(List<Integer> numbers, int bonusNumber) {
        validator.validateNumbers(numbers);
        this.numbers = numbers;
        validator.validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getMoney() {
        return this.money;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
