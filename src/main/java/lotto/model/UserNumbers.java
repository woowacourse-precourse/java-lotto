package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumbers {

    private final List<Integer> NUMBERS = new ArrayList<>();

    public UserNumbers(String userinput) {
        for (String s : stringSplit(userinput)) {
            intValidate(s);
            NumbersAdd(stringConvertInteger(s));
        }
    }

    private Integer stringConvertInteger(String s) {
        return Integer.parseInt(s);
    }

    private void NumbersAdd(Integer userinput) {
        NUMBERS.add(userinput);
    }

    private void intValidate(String s) {
        if (!s.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값입니다..");
        }
    }

    private List<String> stringSplit(String userinput) {
        List<String> stringlist = new ArrayList<>();
        for (String s : userinput.split(",")) {
            stringlist.add(s);
        }
        return stringlist;
    }

}
