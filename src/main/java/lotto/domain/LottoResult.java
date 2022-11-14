package lotto.domain;

public enum LottoResult {
    FIRST("6개 일치 (2,000,000,000원) - ", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    THIRD("5개 일치 (1,500,000원) - ", 1_500_000),
    FOURTH("4개 일치 (50,000원) - ", 50_000),
    FIFTH("3개 일치 (5,000원) - ", 5_000),
    NOTHING("NOTHING", 0);

    String result;
    int prize;

    LottoResult(String result, int prize) {
        this.result = result;
        this.prize = prize;
    }

    public String getName() {
        return result;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoResult getResult(int correctNum, boolean correctBonus) {
        if (correctNum == 6) {
            return FIRST;
        }
        if (correctNum == 5 && correctBonus) {
            return SECOND;
        }
        if (correctNum == 5) {
            return THIRD;
        }
        if (correctNum == 4) {
            return FOURTH;
        }
        if (correctNum == 3) {
            return FIFTH;
        }
        return NOTHING;
    }

}
