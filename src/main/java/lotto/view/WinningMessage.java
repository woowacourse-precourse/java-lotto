package lotto.view;

public enum WinningMessage {

    THIRD_MATCH("3개 일치 (5,000원) - ", 5000),
    FORTH_MATCH("4개 일치 (50,000원) - ", 50000),
    FIFTH_MATCH("5개 일치 (1,500,000원) - ", 1500000),
    BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    SIXTH_MATCH("6개 일치 (2,000,000,000원) - ", 2000000000);

    WinningMessage(String message, int money){
        this.message = message;
        this.money = money;
    }
    private final String message;
    private final int money;

    public String getMessage() {
        return message;
    }
    public int getMoney() {
        return money;
    }
}
