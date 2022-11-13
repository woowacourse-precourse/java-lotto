package lotto.model;

import java.util.List;

import lotto.view.Input;

public class Cashier {
    private int money;
    private List<String> answerNumber;
    private String bonusNumber;

    // enum
    public void inputPlayerValue() {
        money = Input.getYourMoney();
        answerNumber = Input.getAnswerNumbers();
        bonusNumber = Input.getBonusNumber();
    }
    
}

