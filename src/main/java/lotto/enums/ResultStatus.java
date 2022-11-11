package lotto.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum ResultStatus {
    NONE0(0, false),
    NONE1(0, false),
    NONE2(0, false),
    MATCH3(5000, false),
    MATCH4(50000, false),
    MATCH5(1500000, false),
    MATCH5_WITH_BONUS_BALL(30000000, true),
    MATCH6(2000000000, false),
    ;

    private final int value;
    private final boolean hasBonusBall;
    private static final Map<ResultFlag, ResultStatus> map = new HashMap<>();

    ResultStatus(int value, boolean hasBonusBall) {
        this.value = value;
        this.hasBonusBall = hasBonusBall;
    }

    public int getValue() {
        return value;
    }

    public boolean isHasBonusBall() {
        return hasBonusBall;
    }

    private static void getMap() {
        if (!map.isEmpty()) return;
        map.put(new ResultFlag(0), NONE0);
        map.put(new ResultFlag(1), NONE1);
        map.put(new ResultFlag(2), NONE2);
        map.put(new ResultFlag(3), MATCH3);
        map.put(new ResultFlag(4), MATCH4);
        map.put(new ResultFlag(5, false), MATCH5);
        map.put(new ResultFlag(5, true), MATCH5_WITH_BONUS_BALL);
        map.put(new ResultFlag(6), MATCH6);
    }

    public static ResultStatus getResultStatus(int count, boolean hasBonusBall) {
        getMap();
        return map.get(new ResultFlag(count, hasBonusBall));
    }

    static class ResultFlag {
        int count;
        boolean hasBonusBall;

        ResultFlag(int count) {
            this.count = count;
        }

        ResultFlag(int count, boolean hasBonusBall) {
            this.count = count;
            this.hasBonusBall = hasBonusBall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ResultFlag that = (ResultFlag) o;
            if (that.count == 5) {
                return count == that.count && hasBonusBall == that.hasBonusBall;
            }
            return count == that.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(count);
        }
    }
}
