package lotto.Model.enums;

import lotto.Model.Bonus;

import java.util.Arrays;

public enum Prize {
    FIFTH("3개 일치 (5,000원) - ", 3, 0,  0, 5000),
    FOURTH("4개 일치 (50,000원) - ", 4, 0, 0, 50000),
    THIRD("5개 일치 (1,500,000원) - ", 5, 0, 0, 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 5, 1, 0, 30000000),
    FIRST("6개 일치 (2,000,000,000원) - ", 6, 0, 0, 2000000000);

    private final String message;
    private final int count;
    private final int bonusCount;
    private int prizeCount = 0;
    private final int money;

    Prize(String message, int count, int bonusCount, int prizeCount, int money) {
        this.message = message;
        this.count = count;
        this.bonusCount = bonusCount;
        this.prizeCount = prizeCount;
        this.money = money;
    }

    /*
    public static Prize findByIndex(int index) {
        for(Prize prize : Prize.values()) {
            if(prize.index == index) {
                return prize;
            }
        }
        throw new RuntimeException();
    }

     */

    public static Prize findNameByValue(int count, int bonusCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getCount() == count)
                .filter(prize -> prize.getBonusCount() == bonusCount)
                .findFirst()
                .orElse(null);
    }

    public void increaseCount(){
        this.prizeCount +=1;
    }


    public String getMessage() {
        return this.message;
    }

    public int getCount(){
        return this.count;
    }

    public int getBonusCount(){
        return this.bonusCount;
    }

    public int getPrizeCount(){
        return this.prizeCount;
    }

    public int getMoney() {
        return this.money;
    }
}
