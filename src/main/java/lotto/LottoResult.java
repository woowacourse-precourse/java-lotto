package lotto;

public enum LottoResult {
    FIRSTPLACE("6개 번호 일치", "2,000,000,000"),
    SECONDPLACE("5개 번호 + 보너스 번호 일치", "30,000,000"),
    THIRDPLACE("5개 번호 일치", "1,500,000"),
    FOURTHPLACE("4개 번호 일치", "50,000"),
    FIFTHPLACE("3개 번호 일치", "5,000");

    private final String detail;
    private final String money;

    LottoResult(String detail, String money) {
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
