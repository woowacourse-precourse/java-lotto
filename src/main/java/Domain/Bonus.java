package Domain;

import Controller.Validation;
import View.InputView;

public class Bonus {
    private int number;

    public Bonus(String readBonusNumber, Winning winning){
        Validation.validateBonusNumberInput(readBonusNumber, winning.getNumbers());
        this.number = Integer.parseInt(readBonusNumber);
    }

    public int getBonusNumber(){
        return this.number;
    }
}
