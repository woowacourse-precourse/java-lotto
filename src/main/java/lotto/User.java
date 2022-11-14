package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int useCash;
    private List<Integer> winningNumbers;
    private int bonus_number;
    private List<List<Integer>> userLottoNumber;
    public List<Integer> userMatchNumber = new ArrayList<>();


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

    public List<List<Integer>> getUserLottoNumber() {
        return userLottoNumber;
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

    public void setUserLottoNumber(List<List<Integer>> userLottoNumber) {
        this.userLottoNumber = userLottoNumber;
    }

}
