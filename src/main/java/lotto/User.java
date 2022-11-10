package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int money;
    private int bonusNumber;
    private List<Integer> winningNumbers;

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public void setBonusNumber(String userInput) {
        String[] validatedInput = userInput.split(","); // TODO : change to exception check method output
        for (String inputI : validatedInput) {
            winningNumbers.add(Integer.parseInt(inputI));
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
