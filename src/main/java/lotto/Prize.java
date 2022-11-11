package lotto;

public enum Prize {
    FIRST  (20 * 10000 * 10000, "6개 일치 (2,000,000,000원)"),
    SECOND (300 * 10000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD  (15 * 10000, "5개 일치 (1,500,000원)"),
    FORTH  (5 * 10000, "4개 일치 (50,000원)"),
    FIFTH  (5000, "3개 일치 (5,000원)"),
    NOTHING(0, "");

    private int money;
    private String ment;

    static Prize getPrize(int correctCount, boolean isBonusRight){
        if (correctCount == 6) {
            return FIRST;
        }
        if (correctCount == 5) {
            if (isBonusRight)
                return SECOND;
            return THIRD;
        }
        if (correctCount == 4) {
            return FORTH;
        }
        if (correctCount == 3) {
            return FIFTH;
        }
        return NOTHING;
    }

    private Prize (int prizeAmount, String ment){
        money = prizeAmount;
    }

    public int getMoney(){
        return money;
    }

    public String getMent(){
        return ment;
    }
}
