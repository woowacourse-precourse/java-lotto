package constant;

import lotto.PrizeSearchTool;

import java.text.NumberFormat;

public enum Prize {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false,1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ;

    private final int match;

    private final boolean bonus;

    private final int money;

    private final String description;

    Prize(int match, boolean bonus, int money) {
        this.match = match;
        this.bonus = bonus;
        this.money = money;
        this.description = writeDescription();
        PrizeSearchTool.updateSearchTool(this);
    }

    private String writeDescription() {
        return String.format("%d개 일치%s (%s)", match, bonusText(), NumberFormat.getNumberInstance().format(money));
    }

    private String bonusText() {
        if (bonus) {
            return ", 보너스 볼 일치";
        }

        return "";
    }

    public int getMoney() {
        return money;
    }

    public int getMatch() {
        return match;
    }

    public boolean isBonus() {
        return bonus;
    }

    public String getDescription() {
        return description;
    }
}
