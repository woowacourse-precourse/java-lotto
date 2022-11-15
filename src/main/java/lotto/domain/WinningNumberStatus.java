package lotto.domain;

import java.util.Arrays;

public enum WinningNumberStatus {
    FIRST(6, 1, 2_000_000_000),
    SECOND(5, 2, 30_000_000),
    THIRD(5, 3, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(3, 5, 5_000);

    private final int count;
    private final int order;
    private final int money;

    WinningNumberStatus(int count, int order, int money) {
        this.count = count;
        this.order = order;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getOrder() {
        return order;
    }

    public int getMoney() {
        return money;
    }

    public static int getOrderOverTHIRD(int count) {
        return 8 - count;
    }

    public static WinningNumberStatus getWinningNumberStatusByOrder(int order) {
        return Arrays.stream(values())
                .filter(winningNumberStatus -> order == winningNumberStatus.getOrder())
                .findFirst()
                .get();
    }

}
