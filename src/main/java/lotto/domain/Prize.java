package lotto.domain;

import java.util.Arrays;

public enum Prize {
    first(6, false, 2_000_000_000),
    second(5, true, 30_000_000),
    third(5, false, 1_500_000),
    fourth(4, false, 50_000),
    fifth(3, false, 5_000),
    error(0, false, 0);

    private int catchPoint;
    private boolean bonusCatchPoint;
    private int money;

    Prize(int catchPoint, boolean bonusCatchPoint, int money) {
        this.catchPoint = catchPoint;
        this.bonusCatchPoint = bonusCatchPoint;
        this.money = money;
    }

    public static Prize find(int catchPoint, boolean bonusPoint) {
        //2등과 3증 차이 구분
        if (catchPoint == 5) {
            if (bonusPoint) return second;
            return fourth;
        }
        return Arrays.stream(values())
            .filter(prize -> prize.catchPoint == catchPoint)
            .findAny().orElse(error);
    }

    @Override
    public String toString() {
        return "Prize{" +
            "catchPoint=" + catchPoint +
            ", bonusCatchPoint=" + bonusCatchPoint +
            ", money=" + money +
            '}';
    }
}
