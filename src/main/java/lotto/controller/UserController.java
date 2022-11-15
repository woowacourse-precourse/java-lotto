package lotto.controller;

import java.util.List;
import lotto.model.User;

public class UserController {
    final User user = new User();
    private List<Integer> userNumbers;

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int bonusNumber;

    public void getBudget() {
        user.getBudget();
    }

    public int getPublicians(){
        return user.getPublicans();
    }

    public void getUserInputs() {
        user.getNumbers();
        user.getBonusNumber();

        this.userNumbers = user.getUserNumbers();
        this.bonusNumber = user.getBonus();

    }
}
