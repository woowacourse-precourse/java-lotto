package lotto.domain;

public final class Constants {

    public static final class Lotto {
        public static final int SIZE = 6;
        public static final int RANGE_BEGIN = 1;
        public static final int RANGE_END = 45;
    }

    public static final class Money {
        public static final int MINIMUM_AMOUNT = 1000;
        public static final int MAXIMUM_AMOUNT = 100_000;
        public static final int UNIT_AMOUNT = 1000;
    }

    private Constants() {
    }
}
