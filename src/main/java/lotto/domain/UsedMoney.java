package lotto.domain;

import java.util.regex.Pattern;

public class UsedMoney {
    private Integer ableCount;

    public UsedMoney(String money) {
        this.ableCount = checkChange(money);
    }

    private Integer checkChange(String money){
        if (!Pattern.matches("^[0-9]*$", money)){
            throw new IllegalArgumentException(Errors.MONEY_ONLY_NUMBER.getMessage());
        }
        if (Integer.valueOf(money) % 1000 != 0){
            throw new IllegalArgumentException(Errors.CHARGE.getMessage());
        }
        return Integer.valueOf(money) / 1000;
    }

    public Integer getAbleCount() {
        return ableCount;
    }
}
