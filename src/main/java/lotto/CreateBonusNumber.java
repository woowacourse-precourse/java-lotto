package lotto;

import java.util.List;

public class CreateBonusNumber {
    public long getBonusNumber(List<Integer> winningNumber, String userInput){
        Validate checkBonusNumber = new Validate();
        checkBonusNumber.validateBonusNumber(winningNumber, userInput);
        return Long.parseLong(userInput);
    }
}
