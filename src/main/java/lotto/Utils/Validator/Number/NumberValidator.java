package lotto.Utils.Validator.Number;

import lotto.Utils.Validator.IntegerValidator;
import lotto.Utils.Validator.ListValidator;
import lotto.View.OutputView;

import java.util.List;

public class NumberValidator {
    private static final String ERROR_MESSAGE="[ERROR] 보너스 번호가 중복됩니다.";
    public static void isBonusOverlap(List<Integer>lotto, int bonusNumber){
        if(lotto.contains(bonusNumber)){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void checkNumber(String[] input){
        if(!(checkInputNumberList(input) && checkInputNumberOverlap(input))){
            throw new IllegalArgumentException("[ERROR] 오류입니다");
        }
    }

    public static boolean checkInputNumberList(String[] input){
        for(String str : input){
            try {
                IntegerValidator.Integer(str);
                return true;
            }
            catch(Exception e){
                System.err.print(e);
                return false;
            }
        }
        return true;
    }
    public static boolean checkInputNumberOverlap(String[] input){
        try {
            ListValidator.Overlaped(input);
            return true;
        }
        catch(Exception e){
            System.err.print(e);
            return false;
        }
    }
}
