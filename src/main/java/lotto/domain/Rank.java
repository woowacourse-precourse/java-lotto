package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6,2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000 ),
    FIFTH(3, 5000),
    NORANK(0,0);

    private int correctNumCount;
    private int money;


    Rank(int correctNumCount, int money) {
        this.correctNumCount = correctNumCount;
        this.money = money;
    }

    public int getCorrectNumCount() {
        return correctNumCount;
    }

    public int getMoney() {
        return money;
    }

    public static Rank findByCountAndBonus(int count, boolean isCorrectBonus){
        if(SECOND.find(count) && isCorrectBonus){
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.find(count) && rank != SECOND)
                .findAny()
                .orElse(NORANK);
    }

    public boolean find(int count){
        return this.correctNumCount == count;
    }


}

