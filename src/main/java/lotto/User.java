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

}
