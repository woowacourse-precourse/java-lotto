package lotto;

import java.util.List;

public class CreateBonusNumber {
    public int getBonusNumber(List<Integer> winningNumber, String userInput){
        Validate checkBonusNumber = new Validate();
        checkBonusNumber.validateBonusNumber(winningNumber, userInput);
        return Integer.parseInt(userInput);
    }
}
