package lotto;

import java.util.List;

public class CreateBonusNumber {
    public int bonus;
    public void getBonusNumber(List<Integer> winningNumber, String userInput){
        Validate checkBonusNumber = new Validate();
        checkBonusNumber.validateBonusNumber(winningNumber, userInput);
        bonus = Integer.parseInt(userInput);
    }
}
