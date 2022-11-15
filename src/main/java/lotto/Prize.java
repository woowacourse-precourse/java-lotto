package lotto;

public enum Prize {
    FIFTH("3개 일치 (5,000원) - ", 0, 5000),
    FOURTH("4개 일치 (50,000원) - ", 1, 50000),
    THIRD("5개 일치 (1,500,000원) - ", 2, 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 3, 30000000),
    FIRST("6개 일치 (2,000,000,000원) - ", 4, 2000000000);

    private final String message;
    private final int index;
    private final int money;

    Prize(String message, int index, int money) {
        this.message = message;
        this.index = index;
        this.money = money;
    }

    public static Prize findByIndex(int index) {
        for(Prize prize : Prize.values()) {
            if(prize.index == index) {
                return prize;
            }
        }
        throw new RuntimeException();
    }

    public String getMessage() {
        return this.message;
    }

    public int getIndex(){
        return this.index;
    }

    public int getMoney() {
        return this.money;
    }
}
