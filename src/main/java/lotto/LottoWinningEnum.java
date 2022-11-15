package lotto;

import java.text.NumberFormat;

public enum LottoWinningEnum { // WinningStatistics-print-001
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int correctNumber;
    private final boolean hitBonus;
    private final int money;
    private static final String CORRECT_NUMBER_STRING_KEY = "%correctNumber";
    private static final String MONEY_STRING_KEY = "%money";
    private static final String COUNT_NUMBER_STRING_KEY = "%count";
    private static final String NORMAL_FORM_DIFF = "개 일치 (";
    private static final String BONUS_FORM_DIFF = "개 일치, 보너스 볼 일치 (";
    private String printString = CORRECT_NUMBER_STRING_KEY
            + "개 일치 ("
            + MONEY_STRING_KEY
            + "원) - "
            + COUNT_NUMBER_STRING_KEY + "개"
            + System.lineSeparator(); // $correctnumber개 일치 ($money원) - $count개

    LottoWinningEnum(int correctNumber, boolean hitBonus, int money) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        this.correctNumber = correctNumber;
        this.hitBonus = hitBonus;
        this.money = money;
        this.printString = this.printString.replace(CORRECT_NUMBER_STRING_KEY, String.valueOf(correctNumber));
        this.printString = this.printString.replace(MONEY_STRING_KEY, numberFormat.format(money));
        if (hitBonus){
            this.printString = this.printString.replace(NORMAL_FORM_DIFF, BONUS_FORM_DIFF);
        }
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public boolean isHitBonus() {
        return hitBonus;
    }

    public int getMoney() {
        return money;
    }

    public String getPrintString(int countNumber) {
        return printString.replace(COUNT_NUMBER_STRING_KEY, String.valueOf(countNumber));
    }
}
