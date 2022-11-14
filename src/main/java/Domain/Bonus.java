package Domain;

import Controller.Validation;
import View.InputView;

public class Bonus {
    private int number;

    public Bonus(Winning winning){
        this.number = getUniqueBonusNumber(winning);
    }

    public int getUniqueBonusNumber(Winning winning){
        InputView.printInputBonusNumberMessage();
        String readBonusNumber = InputView.readInputLine();
        Validation.validateBonusNumberInput(readBonusNumber, winning.getNumbers());
        int bonusNumber = Integer.parseInt(readBonusNumber);
        return bonusNumber;
    }

    public int getBonusNumber(){
        return this.number;
    }
}
