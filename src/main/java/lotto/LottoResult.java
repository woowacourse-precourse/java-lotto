package lotto;

public enum LottoResult {
    FIFTHPLACE(3, false, 4, "3개 일치 (5,000원) - ", 5000),
    FOURTHPLACE(4, false, 3, "4개 일치 (50,000원) - ", 50000),
    THIRDPLACE(5, false, 2, "5개 일치 (1,500,000원) - ", 1500000),
    SECONDPLACE(5, true, 1, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    FIRSTPLACE(6, false, 0, "6개 일치 (2,000,000,000원) - ", 2000000000);

    private final int count;
    private final boolean bonus;
    private final int index;
    private final String detail;
    private final int money;

    LottoResult(int count, boolean bonus, int index, String detail, int money) {
        this.count = count;
        this.bonus = bonus;
        this.index = index;
        this.detail = detail;
        this.money = money;
    }

    public String getDetail() {
        return detail;
    }

    public int getMoney() {
        return money;
    }

    public int getIndex() {
        return index;
    }

    //count랑 같으면 index 반환
}
