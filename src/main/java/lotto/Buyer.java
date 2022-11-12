package lotto;

import static lotto.view.BuyerView.inputBonusNumber;
import static lotto.view.BuyerView.inputMoney;
import static lotto.view.BuyerView.inputNumbers;

import java.util.List;

public class Buyer {
    private static final int MIN_BUY_UNIT = 1_000;
    private static final String ERROR_UNIT = String.format("[ERROR] 최소 구매 단위는 %s원 입니다.", MIN_BUY_UNIT);
    public int money;
    public List<Integer> numbers;
    public int bonusNumber;

    public Buyer() {
        this.money = getMoney();
        this.numbers = getNumbers();
        this.bonusNumber = getBonusNumber();
    }

    public Buyer(int money, List<Integer> numbers, int bonusNumber) {
        this.money = money;
        validateUnit(money);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private int getMoney() {
        return inputMoney();
    }

    private void validateUnit(Integer money) {
        if (money % MIN_BUY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_UNIT);
        }
    }

    private List<Integer> getNumbers() {
        return inputNumbers();
    }

    private int getBonusNumber() {
        return inputBonusNumber();
    }
}
