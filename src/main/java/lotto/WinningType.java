package lotto;

import static lotto.LottoConstant.*;

public enum WinningType {
    THREE("3개 일치 (5,000원) - ", WINNING_THREE_MONEY),
    FOUR("4개 일치 (50,000원) - ", WINNING_FOUR_MONEY),
    FIVE("5개 일치 (1,500,000원) - ", WINNING_FIVE_MONEY),
    FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", WINNING_FIVE_AND_BONUS_MONEY),
    SIX("6개 일치 (2,000,000,000원) - ", WINNING_SIX_MONEY);

    private final String message;
    private final int money;

    WinningType(String message, int money) {
        this.message = message;
        this.money = money;
    }

    public String getMessage() {
        return message;
    }

    public int getMoney() {
        return money;
    }
}
