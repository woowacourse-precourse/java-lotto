package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    private int money;
    private int hitCount;

    Rank(int hitCount, int money){
        this.hitCount = hitCount;
        this.money = money;
    }

    public static Rank getRanking(int hitCount, boolean bonusNumberHit) {
        Rank rank = getRankingByHitCount(hitCount);
        return checkSecondPlace(rank, bonusNumberHit);
    }

    private static Rank getRankingByHitCount(int hitCount) {
        return rankingsOrderByPriceMoneyAsc().stream()
                .filter(lottoRank -> lottoRank.hitCount == hitCount)
                .findAny()
                .orElse(NOTHING);
    }

    private static Rank checkSecondPlace(Rank rank, boolean bonusNumberHit) {
        if (rank == THIRD && bonusNumberHit) {
            return SECOND;
        }
        return rank;
    }

    public static List<Rank> rankingsOrderByPriceMoneyAsc() {
        return Arrays.stream(values())
                .filter(money -> !money.equals(NOTHING))
                .sorted(Comparator.comparingLong(rank -> rank.money))
                .collect(Collectors.toList());
    }

    public int getMoney(){
        return money;
    }

    public int getHitCount() {
        return hitCount;
    }

    public String getDottedWinningAmount(){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(money);
    }
}
