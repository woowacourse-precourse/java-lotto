package lotto.game;

import java.util.regex.Pattern;

public class LottoService {
    private static final Pattern moneyPattern = Pattern.compile("^[1-9]\\d*$");

    public int convertInputToMoney(String input) {
        if (!validateMoney(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        int money = Integer.parseInt(input);
        if (money % 1000 == 0) {
            return money;
        }
        throw new IllegalArgumentException("[ERROR] 1000으로 나눠 떨어지는 금액만 입력해주세요.");
    }

    private boolean validateMoney(String money) {
        return moneyPattern.matcher(money).matches();
    }
}
