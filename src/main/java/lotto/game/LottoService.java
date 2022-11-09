package lotto.game;

import java.util.regex.Pattern;

public class LottoService {
    private static final Pattern moneyPattern = Pattern.compile("^[1-9]\\d*$");

    public Money convertInputToMoney(String input) {
        if (moneyPattern.matcher(input).matches()) {
            return Money.of(Long.parseLong(input));
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
    }
}
