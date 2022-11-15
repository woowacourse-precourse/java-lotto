package lotto.domain;

import java.util.List;
public class GetBonusNumber {
    public int bonus;
    public void getBonusNumber(List<Integer> winningNumber, String userInput){
        Validate checkBonusNumber = new Validate();
        checkBonusNumber.validateBonusNumber(winningNumber, userInput);
        bonus = Integer.parseInt(userInput);
    }
}
