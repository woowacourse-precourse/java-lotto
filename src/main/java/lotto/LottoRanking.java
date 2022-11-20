package lotto;


import java.text.DecimalFormat;
import java.util.List;

import java.lang.Object;

public enum LottoRanking {
    FIRST("6개 일치", 2000000000, 6, 0),
    SECOND("5개 일치, 보너스 볼 일치", 30000000, 5, 1),
    THIRD("5개 일치", 1500000, 5, 0),
    FORTH("4개 일치", 50000, 4, 0),
    FIFTH("3개 일치", 5000, 3, 0)
    ;


    private String message;
    private int price;
    private int count;
    private int bonusCount;

    LottoRanking(String message, int price, int count, int bonusCount) {
        this.message = message;
        this.price = price;
        this.count = count;
        this.bonusCount = bonusCount;
    }

    public String getMessage(){
        return new String(message);
    }

    public int getPrice(){
        return price;
    }

    public int getCount(){
        return count;
    }

    public int getBonusCount(){
        return bonusCount;
    }

    static LottoRanking caculateRanking(List<Integer> target, int bonusNumber, List<Integer> input){
        int count = 0;
        int bonusCount = 0;
        for(int i : input){
            if(target.contains(i)){
                count += 1;
            }
            else if(bonusNumber == i){
                bonusCount += 1;
            }
        }

        return findByCountAndBonusCount(count, bonusCount);
    }

    private static LottoRanking findByCountAndBonusCount(int count, int bonusCount){
        for(LottoRanking ranking : values()) {
            if (ranking.getCount() == count && ranking.getBonusCount() == bonusCount) {
                return ranking;
            }
            else if(ranking.getCount() == count){
                return ranking;
            }
        }

        return null;
    }


    public String toString(){
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return String.format("%s (%s원)",this.getMessage(), decFormat.format(this.getPrice()));
    }
}