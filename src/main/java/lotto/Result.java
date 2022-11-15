package lotto;

import java.util.Arrays;

public enum Result {
    DEFAULT(0, false, "상금 없음", 0),
    FIFTH(3, false, "3개 일치 (5,000원) - ", 5000),
    FOURTH(4, false, "4개 일치 (50,000원) - ", 50000),
    THIRD(5, false, "5개 일치 (1,500,000원) - ", 1500000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    FIRST(6, false, "6개 일치 (2,000,000,000원) - ", 2000000000);

    private final int correctCount;
    private final boolean isBonus;
    private final String print;
    private final int price;

    Result(int correctCount, boolean isBonus, String print, int price){
        this.correctCount = correctCount;
        this.isBonus = isBonus;
        this.print = print;
        this.price = price;
    }

    public String print(){
        return print;
    }

    public static Result getResult(int correctCount, boolean isBonus){
        return Arrays.stream(Result.values())
                .filter(result -> (result.isBonus==isBonus && result.correctCount==correctCount))
                .findAny()
                .orElse(DEFAULT);
    }

    public static Result getRank(int numberOfMatch, boolean isContainBounus){
        if (numberOfMatch == 5)
            if (isContainBounus)
                return SECOND;

        return Arrays.stream(values())
                .filter(ranking -> ranking.correctCount == numberOfMatch)
                .findFirst()
                .orElse(DEFAULT);
    }

    public Integer getPrice()
    {
        return this.price;
    }
}
