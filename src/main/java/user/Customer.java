package user;

import store.Lotto;

import java.util.List;
import java.util.regex.Pattern;

public class Customer {
    private static final String NUMERIC_ERROR = "[ERROR] 숫자를 입력해 주시기 바랍니다.";

    private List<Lotto> lotteries;
    private int pay;

    public Customer(String readline) {
        validateNumeric(readline);
        int pay = Integer.parseInt(readline);
        this.pay = pay;
    }

    private void validateNumeric(String readline) {
        if (Pattern.matches("^\\d", readline)) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }

}
