package lotto.domain;

import static lotto.util.GenerateLottoNumbers.generateLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int amount;
    private int winnings;
    private List<UserLotto> autoNumbers;

    public User(int amount) {
        autoNumbers = new ArrayList<>();
        this.amount = amount;
        this.winnings = 0;
    }

    public void setAutoNumbers(int amount) {
        this.autoNumbers = generateLottoNumbers(amount);
    }

    public List<UserLotto> getAutoNumbers() {
        return autoNumbers;
    }

    public int getAmount() {
        return amount;
    }

    public int getWinnings() {
        return winnings;
    }

    public void addWinnings(int money) {
        winnings += money;
    }
}