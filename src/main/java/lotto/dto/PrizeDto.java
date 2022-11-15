package lotto.dto;

import lotto.domain.lottoenum.Prize;

public class PrizeDto {
    private final int money;
    private final int count;
    private final int matchCount;
    private final boolean hasBonus;

    private PrizeDto(int money, long count, int matchCount, boolean hasBonus) {
        this.money = money;
        this.count = (int) count;
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public static PrizeDto of(Prize prize, long count) {
        return new PrizeDto(prize.getMoney(), count, prize.getMatchCount(), prize.getHasBonus());
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}
