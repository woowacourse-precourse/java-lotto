package lotto;

public class CreateBonusNumber {
    public int getBonusNumber(String userInput){
        Validate checkBonusNumber = new Validate();
        checkBonusNumber.validateBonusNumber(userInput);
        return Integer.parseInt(userInput);
    }
}
