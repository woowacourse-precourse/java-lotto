package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Utility;

public class UserNumbersController {

    private final Lotto NUMBERS;
    private final int BONUS_NUMBER;

    public UserNumbersController(String usernumbers, String bonusnumber) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : stringSplit(usernumbers)) {
            Utility.intValidate(s);
            numbers.add(stringConvertInteger(s));
        }
        this.NUMBERS = new Lotto(numbers);
        this.BONUS_NUMBER = IntegerValidate(bonusnumber);
    }

    private Integer stringConvertInteger(String s) {
        return Integer.parseInt(s);
    }

    private int IntegerValidate(String s) {
        Utility.intValidate(s);
        return Integer.parseInt(s);
    }


    private List<String> stringSplit(String userinput) {
        List<String> stringlist = new ArrayList<>();
        for (String s : userinput.split(",")) {
            stringlist.add(s);
        }
        return stringlist;
    }

    public Lotto getNUMBERS() {
        return NUMBERS;
    }


}
