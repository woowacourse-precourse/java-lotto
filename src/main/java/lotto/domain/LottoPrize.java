package lotto.domain;

import java.text.DecimalFormat;

public enum LottoPrize {
    FIRST_PRIZE("1등", "6개 일치", 2000000000),
    SECOND_PRIZE("2등", "5개 일치, 보너스 볼 일치", 30000000),
    THIRD_PRIZE("3등", "5개 일치", 1500000),
    FOURTH_PRIZE("4등", "4개 일치", 50000),
    FIFTH_PRIZE("5등", "3개 일치", 5000),
    SIXTH_PRIZE("6등", "1-5등 제외", 0);
    private final DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private String title;
    private String condition;
    private int prize;

    LottoPrize(String title, String condition, int prize) {
        this.title = title;
        this.condition = condition;
        this.prize = prize;
    }
    public int ofPrize(){
        return prize;
    }
    public String ofDescription() {
        return condition + " (" + decimalFormat.format(prize) + "원)";
    }
}
