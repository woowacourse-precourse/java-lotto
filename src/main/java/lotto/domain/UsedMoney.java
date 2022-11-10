package lotto.domain;

import java.util.regex.Pattern;

public class UsedMoney {
    private static final String ONLY_NUMBER_ERROR_MESSAGE = "[ERROR] 금액은 숫자여야합니다.";
    private static final String CHARGE_ERROR_MESSAGE = "[ERROR] 금액은 1000단위로 투입해야합니다.";
    private Integer ableCount;

    public UsedMoney(String money) {
        this.ableCount = checkChange(money);
    }

    private Integer checkChange(String money){
        if (!Pattern.matches("^[0-9]*$", money)){
            throw new IllegalArgumentException(ONLY_NUMBER_ERROR_MESSAGE);
        }
        if (Integer.valueOf(money) % 1000 != 0){
            throw new IllegalArgumentException(CHARGE_ERROR_MESSAGE);
        }
        return Integer.valueOf(money) / 1000;
    }

    public Integer getAbleCount() {
        return ableCount;
    }
}
