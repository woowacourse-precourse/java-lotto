package Domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Prize {
    FIFTH_PRIZE(3, false, 5,5_000),
    FOURTH_PRIZE(4, false, 4,50_000),
    THIRD_PRIZE(5, false, 3,1_500_000),
    SECOND_PRIZE(5, true, 2,30_000_000),
    FIRST_PRIZE(6, false, 1, 2_000_000_000);

    private final int count;
    private final boolean bonusCheck;
    private final int rank;
    private final int prizeMoney;

    Prize(int count, boolean bonusCheck, int rank, int prizeMoney) {
        this.count = count;
        this.bonusCheck = bonusCheck;
        this.rank = rank;
        this.prizeMoney = prizeMoney;
    }

    public static int getPrizeMoney(int count, int[] ranking, boolean compareBonus){

        List<Prize> prizes = Arrays.stream(Prize.values())
                .filter(prize -> prize.getCount() == count)
                .sequential().collect(Collectors.toList());

        if(prizes.size() == 1) {
            Prize selectPrize = prizes.get(0);
            ranking[selectPrize.getRank()] += 1;
            return selectPrize.getPrizeMoney();
        }
        if(prizes.size() == 2){ //2등인지 3등인지 구별하는 작업
            Prize selectPrize = prizes.stream()
                    .filter(prize -> prize.getBonusCheck() == compareBonus)
                    .sequential().collect(Collectors.toList())
                    .get(0);
            ranking[selectPrize.getRank()] += 1;
            return selectPrize.getPrizeMoney();
        }
        return 0;
    }

    public int getCount(){
        return this.count;
    }

    public boolean getBonusCheck(){
        return this.bonusCheck;
    }

    public int getRank(){
        return this.rank;
    }

    public int getPrizeMoney(){
        return this.prizeMoney;
    }
}

