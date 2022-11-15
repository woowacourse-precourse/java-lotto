package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(-1, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    ZERO(0, 0, "");

    private final int count;
    private final long winnings;
    private final String message;

    Rank(int count, long winnings, String message){
        this.count = count;
        this.winnings = winnings;
        this.message = message;
    }

    public int getCount(){
        return count;
    }
    public long getWinnings(){
        return winnings;
    }
    public String getMessage(){
        return message;
    }

}
