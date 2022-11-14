package lotto.model;

import lotto.view.OutputView;

import java.util.List;

public class BonusNumber {

    static OutputView outputView = new OutputView();

    public static int checkBonusNumber(List<Integer> number, String bonus) {
        isNumber(bonus);
        rangeNumber(bonus);
        isEqualNumber(bonus, number);
        return Integer.parseInt(bonus);
    }

    public static boolean rangeNumber(String bonus){
        int number = Integer.parseInt(bonus);
        if(!(number >= 1 && number <=45)) {
            inputError(outputView.rangeMsg());
        }
        return true;
    }

    public static boolean isNumber(String bonus){
        try {
            int number = Integer.parseInt(bonus);
        }catch (NumberFormatException e) {
            inputError(outputView.isNumberMsg());
        }
        return true;
    }

    public static boolean isEqualNumber(String bonus, List<Integer> number) {
        int num = Integer.parseInt(bonus);
        for(Integer i : number) {
           isEqual(num,i);
        }
        return true;
    }

    private static void isEqual(int num, int i) {
        if(num == i) {
            inputError(outputView.equalBonusMsg());
        }
    }

    private static void inputError(String error) {
        throw new IllegalArgumentException(error);
    }
}
