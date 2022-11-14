package lotto.Model;

import lotto.Utils.Converter;
import lotto.Utils.Validator.IntegerValidator;
import lotto.Utils.Validator.ListValidator;
import lotto.Utils.Validator.NumberValidator;
import lotto.View.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;



public class Number {

    private final List<Integer> winningNumberList;
    private final int bonusNumber;

    public Number(){
        this.winningNumberList = inputNumber();
        this.bonusNumber = inputBonusNumber();
    }
    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }
    public int getBonusNumber() {
        NumberValidator.isBonusOverlap(winningNumberList, bonusNumber);
        return bonusNumber;
    }

    private List<Integer> inputNumber() {
        InputView.winNumber();
        String[] inputString = Console.readLine().split(",");
        for(String str : inputString){
            IntegerValidator.Integer(str);
        }
        ListValidator.Overlaped(inputString);
        return Converter.stringArrayToIntegerList(inputString);
    }

    public int inputBonusNumber() {
        InputView.BonusNumber();
        String bonus = Console.readLine();
        IntegerValidator.Integer(bonus);
        ListValidator.validateRange(bonus);
        return Integer.parseInt(bonus);
    }

}
