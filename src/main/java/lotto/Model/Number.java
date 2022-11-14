package lotto.Model;

import lotto.Utils.Validator.Validation;
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
        return bonusNumber;
    }
    private List<Integer> inputNumber() {
        InputView.winNumber();
        String[] inputString = Console.readLine().split(",");
        for(String str : inputString){
            Validation.Integer(str);
        }
        Validation.Overlaped(inputString);
        return Validation.stringArrayToIntegerList(inputString);
    }
    public int inputBonusNumber() {
        InputView.BonusNumber();
        String bonus = Console.readLine();
        Validation.Integer(bonus);
        Validation.validateRange(bonus);
        return Integer.parseInt(bonus);
    }





}
