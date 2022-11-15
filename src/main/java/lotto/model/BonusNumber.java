package lotto.model;

import lotto.view.OutputView;

import java.util.List;
import java.util.regex.Pattern;

public class BonusNumber {

    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    public static int checkBonusNumber(List<Integer> number, String bonus) {
        isNumber(bonus);
        rangeNumber(bonus);
        isEqualNumber(bonus, number);
        return Integer.parseInt(bonus);
    }

    public static boolean rangeNumber(String bonus){
        int number = Integer.parseInt(bonus);
        if(!(number >= 1 && number <=45)) {
            User.inputError(OutputView.rangeMsg());
        }
        return true;
    }

    public static boolean isNumber(String bonus){
        if(!(pattern.matcher(bonus).matches())) {
            User.inputError(OutputView.isNumberMsg());
        }
        return true;
    }

    public static boolean isEqualNumber(String bonus, List<Integer> number) {
        int bonusNum = Integer.parseInt(bonus);
        for(Integer num : number) {
           isEqual(bonusNum, num);
        }
        return true;
    }

    private static void isEqual(int num1, int num2) {
        if(num1 == num2) {
            User.inputError(OutputView.equalBonusMsg());
        }
    }
}
