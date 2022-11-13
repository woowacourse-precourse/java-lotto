package lotto.model;

import lotto.view.OutputView;

import java.util.List;

public class BonusNumber {

    OutputView outputView = new OutputView();

    public void checkBonusNumber(List<Integer>number, String bonus) {
        isNumber(bonus);
        RangeNumber(bonus);
        isEqualNumber(bonus, number);
    }

    public boolean RangeNumber(String bonus){
        int number = Integer.parseInt(bonus);
        if(!(number >= 1 && number <=45)) {
            inputError(outputView.RangeMsg());
        }
        return true;
    }

    public boolean isNumber(String bonus){
        try {
            int number = Integer.parseInt(bonus);
        }catch (NumberFormatException e) {
            inputError(outputView.isNumberMsg());
        }
        return true;
    }

    public boolean isEqualNumber(String bonus, List<Integer> number) {
        int num = Integer.parseInt(bonus);
        for(Integer i : number) {
           isEqual(num,i);
        }
        return true;
    }

    private void isEqual(int num, int i) {
        if(num == i) {
            inputError(outputView.EqualBonusMsg());
        }
    }

    private void inputError(String error) {
        throw new IllegalArgumentException(error);
    }
}
