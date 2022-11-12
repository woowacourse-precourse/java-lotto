package lotto;

import static lotto.view.BuyerView.inputMoney;
import static lotto.view.BuyerView.inputNumbers;

import java.util.List;

public class Buyer {
    public int money;
    public List<Integer> numbers;

    public Buyer() {
        this.money = getMoney();
        this.numbers = getNumbers();
    }

    public Buyer(int money, List<Integer> numbers) {
        this.money = money;
        this.numbers = numbers;
    }

    private int getMoney() {
        return inputMoney();
    }

    private List<Integer> getNumbers() {
        return inputNumbers();
    }
}
