package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumbers {

    private final List<Integer> NUMBERS = new ArrayList<>();

    public UserNumbers(String userinput) {
        for (String s : stringSplit(userinput)) {
            Utility.intValidate(s);
            NumbersAdd(stringConvertInteger(s));
        }
    }

    private Integer stringConvertInteger(String s) {
        return Integer.parseInt(s);
    }

    private void NumbersAdd(Integer userinput) {
        NUMBERS.add(userinput);
    }



    private List<String> stringSplit(String userinput) {
        List<String> stringlist = new ArrayList<>();
        for (String s : userinput.split(",")) {
            stringlist.add(s);
        }
        return stringlist;
    }

    public List<Integer> getNUMBERS() {
        return NUMBERS;
    }


}
