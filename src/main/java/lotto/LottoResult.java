package lotto;

public enum LottoResult {
    FIRSTPLACE(6, false, 0, "6개 번호 일치", "2,000,000,000"),
    SECONDPLACE(5, true, 1, "5개 번호 + 보너스 번호 일치", "30,000,000"),
    THIRDPLACE(5, false, 2, "5개 번호 일치", "1,500,000"),
    FOURTHPLACE(4, false, 3, "4개 번호 일치", "50,000"),
    FIFTHPLACE(3, false, 4, "3개 번호 일치", "5,000");

    private final int count;
    private final boolean bonus;
    private final int index;
    private final String detail;
    private final String money;

    LottoResult(int count, boolean bonus, int index, String detail, String money) {
        this.count = count;
        this.bonus = bonus;
        this.index = index;
        this.detail = detail;
        this.money = money;
    }

    public String getDetail() {
        return detail;
    }

    public String getMoney() {
        return money;
    }
}
