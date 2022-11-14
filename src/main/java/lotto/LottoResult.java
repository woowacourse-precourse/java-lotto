package lotto;

public enum LottoResult {
    FIRST_PRIZE(2000000000, 6, "6개 일치 (2,000,000,000원) -"),
    SECOND_PRIZE(30000000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    THIRD_PRIZE(1500000, 5, "5개 일치 (1,500,000원) -"),
    FOURTH_PRIZE(50000, 4, "4개 일치 (50,000원) -"),
    FIFTH_PRIZE(5000, 3, "3개 일치 (5,000원) -"),
    NO_PRIZE(0, 0, "낙첨 (0원) -");

    private int money;
    private int match;
    private String message;

    private LottoResult(int money, int match, String message) {
        this.money = money;
        this.match = match;
        this.message = message;
    }

    public int getMoney() {
        return money;
    }

    public LottoResult getLottoResult(int match, boolean bonusMatch) {
        if (match == 5 && bonusMatch) {
            return SECOND_PRIZE;
        }

        for (LottoResult lottoResult: LottoResult.values()) {
            if (lottoResult.match == match) {
                return lottoResult;
            }
        }

        return NO_PRIZE;
    }

}
