package lotto.util;

public enum LOTTERY_REWARD {
    FOURTH_PLACE(3, "3개 일치 (5,000원) - ",  5000),
    THIRD_PLACE(4, "4개 일치 (50,000원) - ", 50000),
    SECOND_PLACE(5, "5개 일치 (1,500,000원) - ", 1500000),
    BONUS_PLACE(7, "5개 일치, 보너스 볼 일치 (30,000,000원) -", 30000000),
    FIRST_PLACE(6, "6개 일치 (2,000,000,000원) - ", 2000000000);

    private int index;
    private String message;
    private int cost;

    LOTTERY_REWARD(int index, String message, int cost) {
        this.index = index;
        this.message = message;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return message;
    }

    public int getCost() {
        return cost;
    }

}
