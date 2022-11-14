package lotto;

public enum LottoResult implements Valued {
    FIRST_PLACE{
        public int value() {
            return 2000000000;
        }
    },
    SECOND_PLACE{
        public int value() {
            return 30000000;
        }
    },
    THIRD_PLACE{
        public int value() {
            return 1500000;
        }
    },
    FOURTH_PLACE{
        public int value() {
            return 50000;
        }
    },
    FIFTH_PLACE{
        public int value() {
            return 5000;
        }
    },
    LAST_PLACE{
        public int value() {
            return 0;
        }
    }
}
