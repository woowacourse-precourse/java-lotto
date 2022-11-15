package Domain;

import Controller.Validation;

public class BonusNumber {
    private int number;

    public BonusNumber(String readBonusNumber, WinningNumbers winningNumbers){
        Validation.validateBonusNumberInput(readBonusNumber, winningNumbers.getNumbers());
        this.number = Integer.parseInt(readBonusNumber);
    }

    public int getBonusNumber(){
        return this.number;
    }
}
