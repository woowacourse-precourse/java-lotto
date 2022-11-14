package lotto;

import java.util.List;

public class User {
    private int useCash;
    private List<Integer> winningNumbers;
    private int bonus_number;

    public User() {
    }


    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus_number() {
        return bonus_number;
    }

    public int getUseCash() {
        return useCash;
    }

    public void setUseCash(int useCash) {
        this.useCash = useCash;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonus_number(int bonus_number) {
        this.bonus_number = bonus_number;
    }
}
