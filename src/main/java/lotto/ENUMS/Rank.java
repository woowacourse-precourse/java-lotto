package lotto.ENUMS;

import java.util.function.Function;

public enum Rank {
    RANK1("6개 일치", 2000000000),
    RANK2("5개 일치, 보너스 볼 일치", 30000000),
    RANK3("5개 일치", 1500000),
    RANK4("4개 일치", 50000),
    RANK5("3개 일치", 5000),
    RANK_NONE("해당 사항 없음", 0);

    String condition;
    int winnings;


    Rank(String condition, int winnings) {
        this.condition = condition;
        this.winnings = winnings;
    }

    public String getCondition() {
        return condition;
    }

    public int getWinnings() {
        return winnings;
    }
}
