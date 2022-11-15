package lotto.controller;

import java.util.List;
import lotto.model.User;

public class UserController {
    final User user = new User();
    private List<Integer> userNumbers;
    private int bonusNumber;

    public void getBudget() {
        user.getBudget();
    }

    public void getUserInputs() {
        user.getNumbers();
        user.getBonusNumber();

        this.userNumbers = user.getUserNumbers();
        this.bonusNumber = user.getBonus();

    }
}
