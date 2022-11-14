package lotto.utils;

public enum Ranking {
    FIRST_PLACE(6, 2_000_000_000, "6개 일치 (2,000,000,000)원"),
    SECOND_PLACE(7, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PLACE(5, 15_000_000, "5개 일치, (1,500,000원)"),
    FOURTH_PLACE(4, 50_000, "4개 일치, (50,000원)"),
    FIFTH_PLACE(3, 5_000, "3개 일치 (5,000원)"),
    NOTHING(0, 0, "당첨되지 않았습니다.");

    private final int numberCount;
    private final int money;
    private final String printSentence;

    Ranking(int numberCount, int money, String printSentence) {
        this.numberCount = numberCount;
        this.money = money;
        this.printSentence = printSentence;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public int getMoney() {
        return money;
    }

    public String getPrintSentence() {
        return printSentence;
    }

    public static Ranking checkNumberCount(int count) {
        if (count == FIRST_PLACE.getNumberCount())
            return FIRST_PLACE;
        if (count == SECOND_PLACE.getNumberCount())
            return SECOND_PLACE;
        if (count == THIRD_PLACE.getNumberCount())
            return THIRD_PLACE;
        if (count == FOURTH_PLACE.getNumberCount())
            return FOURTH_PLACE;
        if (count == FIFTH_PLACE.getNumberCount())
            return FIFTH_PLACE;
        return NOTHING;
    }
}
