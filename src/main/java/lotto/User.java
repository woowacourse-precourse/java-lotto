package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int money;
    private int bonusNumber;
    private List<Integer> winningNumbers;

    public User() {
        this.money = -1;
        this.bonusNumber = -1;
        this.winningNumbers = new ArrayList<>();
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public void setWinningNumbers(String userInput) {
        String[] validatedInput = userInput.split(","); // TODO : change to exception check method output
        for (String inputI : validatedInput) {
            winningNumbers.add(Integer.parseInt(inputI));
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
