package lotto;

import lotto.Enums.ErrorMessage;

import java.util.ArrayList;

public class Utils {

    public ArrayList<Integer> parsingInput() {
        ArrayList<Integer> parsed = new ArrayList<>();

        return parsed;
    }

    public boolean checkLottoType() {
        return true;
    }

    public static int string2int(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_TYPE.getMessage(), e);
        }
    }

    public void printResult() {

    }

    private int calYield() {
        return 100;
    }


}
