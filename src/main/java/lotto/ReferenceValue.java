package lotto;

public class ReferenceValue {

    public static final int NOTHING = 0;
    public static final Long MULTIPLE_HUNDRED = 100L;
    public static final Long MULTIPLE_FIRST_DECIMAL = 10L;
    public static final double DIVIDE_FIRST_DECIMAL = 10.0;

    public static final String LINE_BREAK = "\n";

    public enum Lotto {
        SIZE("크기", 6),
        PRICE("가격", 1_000),
        MAX_COUNTS("제한갯수",8_145_060),
        START_RANGE("최솟값", 1),
        END_RANGE("최댓값", 45),
        IS_BONUS("보너스",777);

        private final String name;
        private final Integer value;
        Lotto(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        public Integer getValue() {
            return this.value;
        }
    }
    public enum WinningStats {

        BELOW_STANDARD(0, 0, 0L, ""),
        THREE_MATCHES(1, 3, 5_000L, "3개 일치 (5,000원) - %d개"),
        FOUR_MATCHES(2, 4, 50_000L, "4개 일치 (50,000원) - %d개"),
        FIVE_MATCHES(3, 5, 1_500_000L, "5개 일치 (1,500,000원) - %d개"),
        FIVE_BONUS_MATCHES(4, 5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
        SIX_MATCHES(5, 6, 2_000_000_000L, "6개 일치 (2,000,000,000원) - %d개");

        private final int index;
        private final int count;
        private final Long money;
        private final String message;

        WinningStats(int index, int count, Long money, String message) {
            this.index = index;
            this.count = count;
            this.money = money;
            this.message = message;
        }

        public int getIndex() {
            return this.index;
        }
        public int getCount() {
            return this.count;
        }

        public Long getMoney() {
            return this.money;
        }
        public String getMessage() {
            return this.message;
        }


        public boolean equalsIndex(int index) {
            return this.index == index;
        }
        public boolean equalsCount(int count) {
            return this.count == count;
        }
    }
}
