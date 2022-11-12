package lotto.model;

import lotto.view.OutputView;

public class User {

    OutputView outputView = new OutputView();

    public boolean isNumber(String str){
        try {
            int value = Integer.parseInt(str);
        }catch (NumberFormatException e) {
            inputError(outputView.isNumberMsg());
        }
        return true;
    }

    public boolean unitError(String str) {
        int value = Integer.parseInt(str);
        if(value % 1000 != 0) {
            inputError(outputView.unitErrorMsg());
        }
        return true;
    }

    public void inputError(String error) {
        throw new IllegalArgumentException(error);
    }

    public int lottoCount(String str) {
        int count = Integer.parseInt(str);
        count = count / 1000;
        return count;
    }
}
