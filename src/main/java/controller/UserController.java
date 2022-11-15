package controller;

import domain.user.Number;
import domain.user.User;
import model.Model;
import domain.validation.Validation;
import view.View;

public class UserController {

    private User user;

    public void saveAmount() {

        Model model = Model.getInstance();
        String input = View.setAmount();

        try {
            Validation.validateInput(input);
            int amount = Integer.parseInt(input);

            Validation.validateAmount(amount);
            int count = amount / 1000;

            user = new User(amount, count);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        model.setUser(user);
    }

    public void saveNumber() {
        Model model = Model.getInstance();
        String input = View.createWinningNumber();

        Validation.validateWinningNumbersInput(input);
        user.setNumber(new Number(input));

        input = View.createBonusNumber();
        Validation.validateInput(input);

        int bonusNumber = Integer.parseInt(input);
        user.getNumber().setBonusNumber(bonusNumber);

        model.setUser(user);
    }
}
