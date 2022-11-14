package lotto;

public class ReferenceValue {

    public static final int NOTHING = 0;
    public static final int MULTIPLE_HUNDRED = 100;
    public static final int MULTIPLE_FIRST_DECIMAL = 10;
    public static final double DIVIDE_FIRST_DECIMAL = 10.0;

    public static final String LINE_BREAK = "\n";

    public enum Lotto {
        SIZE("크기", 6),
        PRICE("가격", 1_000),
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

        BELOW_STANDARD(0, 0, 0, ""),
        THREE_MATCHES(1, 3, 5_000, "3개 일치 (5,000원) - "),
        FOUR_MATCHES(2, 4, 50_000, "4개 일치 (50,000원) - "),
        FIVE_MATCHES(3, 5, 1_500_000, "5개 일치 (1,500,000원) - "),
        FIVE_BONUS_MATCHES(4, 5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        SIX_MATCHES(5, 6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

        private final int money;
        private final int index;
        private final int count;
        private final String message;

        WinningStats(int index, int count, int money, String message) {
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

        public int getMoney() {
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
