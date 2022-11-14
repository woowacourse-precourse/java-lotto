package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {

    private final Lotto NUMBERS;
    private final int BONUS_NUMBER;


    public UserLotto(String usernumbers, String bonusnumber) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : stringSplit(usernumbers)) {
            numbers.add(IntegerValidate(s));
        }
        this.NUMBERS = new Lotto(numbers);
        validate(bonusnumber);
        this.BONUS_NUMBER = IntegerValidate(bonusnumber);
    }

    private void validate(String bonusNumber) {
        if (NUMBERS.getNumbers().contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨번호에 포함되어있습니다.");
        }
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

    public int getBONUS_NUMBER() {
        return BONUS_NUMBER;
    }

}
