package lotto;

import java.text.DecimalFormat;

public enum LottoPrize {
    FIRST(6, "6개 일치", 2000000000), 
    SECOND(5, "5개 일치, 보너스 볼 일치", 30000000), 
    THIRD(5, "5개 일치", 1500000), 
    FOURTH(4, "4개 일치", 50000), 
    FIFTH(3, "3개 일치", 5000), 
    NONE(0, "낙첨", 0);

    private int matches;
    private int lottoPrizeMoney;
    private String description;


    LottoPrize(int matches, String description, int prizeMoney) {
        this.matches = matches;
        this.description = description;
        this.lottoPrizeMoney = prizeMoney;
    }

    public int getLottoPrizeMoney() {
        return lottoPrizeMoney;
    }

    public LottoPrize getPrize(int matches) {
        LottoPrize[] val = values();
        for (int index = 0; index < val.length; index++) {
            if (val[index].matches == matches)
                return val[index];
        }
        return LottoPrize.NONE;
    }

    public String getDescription() {
        DecimalFormat commaBy000 = new DecimalFormat("#,###");

        String str = this.description + " (" + commaBy000.format(this.lottoPrizeMoney) + "원)";
        return str;
    }

}
