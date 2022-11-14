package lotto;

public enum LottoResult {
    FIRST_PRIZE(2000000000, "6개 일치 (2,000,000,000)원 - "),
    SECOND_PRIZE(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_PRIZE(1500000, "5개 일치 (1,500,000원) - "),
    FOURTH_PRIZE(50000, "4개 일치 (50,000원) - "),
    FIFTH_PRIZE(5000, "3개 일치 (5,000원) - ");

    private int money;
    private String message;

    private LottoResult(int money, String message) {
        this.money = money;
        this.message = message;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }

}
