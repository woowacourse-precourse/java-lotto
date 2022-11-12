package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.regex.Pattern;

public class Buyer {
    private final String ERROR_NOT_INT = "[ERROR] 숫자만 입력 가능합니다.";
    private final String REGEX_INT = "^[0-9]+$";
    public int money;
    
    public void setMoney() {
        String input = readLine();
        isValidMoneyInput(input);
        this.money = Integer.parseInt(input);
    }

    private void isValidMoneyInput(String input) {
        if (!Pattern.matches(REGEX_INT, input)) {
            throw new IllegalArgumentException(ERROR_NOT_INT);
        }
    }
}
