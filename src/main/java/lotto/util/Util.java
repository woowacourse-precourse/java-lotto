package lotto.util;

public final class Util {
    private Util() {}

    public static float calculateYield(float totalMoney, float beforeMoney) {
        return (totalMoney / beforeMoney) * 100 - 100;
    }
}

