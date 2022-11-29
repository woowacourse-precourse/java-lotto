package lotto.model;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Prize {
    THREE_STRIKE(3, false,5_000),
    FOUR_STRIKE(4,false,   50_000),
    FIVE_STRIKE(5, false, 1_500_000),
    FIVE_STRIKE_WITH_BONUS(5,true,  30_000_000),
    SIX_STRIKE(6,  false,2_000_000_000);

    private Integer matchCount;
    private Boolean isBonus;
    private Integer money;

    Prize(Integer matchCount, Boolean isBonus, Integer money) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.money = money;
    }

    public Integer calculate(int count) {
        return money * count;
    }

    public static Prize getPrizeByMatchCountAndBonus(Integer matchCount, Boolean isBonus) {
        return Arrays.stream(values())
                .filter(i -> i.matchCount.equals(matchCount))
                .filter(i -> i.isBonus == isBonus)
                .findFirst()
                .orElse(null);
    }

    public String getMessage() {
        String prefixMessage = getPrizeMessage();
        String suffixMessage = getMoneyMessage(money);
        return prefixMessage + suffixMessage;
    }

    public String getPrizeMessage() {
        String prizeMessage = matchCount + "개 일치";
        if (isBonus) {
            prizeMessage += ", 보너스 볼 일치";
        }
        return prizeMessage;
    }

    public String getMoneyMessage(int money) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        String moneyByDecimalFormat = decFormat.format(money);
        return " (" + moneyByDecimalFormat + "원)";
    }
}