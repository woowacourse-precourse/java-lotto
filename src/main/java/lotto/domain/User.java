package lotto.domain;

import lotto.view.OutputView;
import java.util.regex.Pattern;

public class User{

    private static final Pattern pattern = Pattern.compile("^[0-9]*$");

    public static boolean isNumber(String str){
        if(!(pattern.matcher(str).matches())) {
            inputError(OutputView.isNumberMsg());
        }
        return true;
    }

    public static boolean unitError(String str) {
        int value = Integer.parseInt(str);
        if(value % 1000 != 0) {
            inputError(OutputView.unitErrorMsg());
        }
        return true;
    }

    public static void inputError(String error) {
        throw new IllegalArgumentException(error);
    }

    public static void checkError(String str) {
        isNumber(str);
        unitError(str);
    }

    public static int lottoCount(String str) {
        int count = Integer.parseInt(str);
        count = count / 1000;
        return count;
    }
}
