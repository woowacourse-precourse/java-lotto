package lotto.model;

import lotto.view.OutputView;

public class User {

    static OutputView outputView = new OutputView();

    public static boolean isNumber(String str){
        try {
            int value = Integer.parseInt(str);
        }catch (NumberFormatException e) {
            inputError(outputView.isNumberMsg());
        }
        return true;
    }

    public static boolean unitError(String str) {
        int value = Integer.parseInt(str);
        if(value % 1000 != 0) {
            inputError(outputView.unitErrorMsg());
        }
        return true;
    }

    private static void inputError(String error) {
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
