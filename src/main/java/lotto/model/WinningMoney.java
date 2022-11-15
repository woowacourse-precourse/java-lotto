package lotto.model;

public enum WinningMoney {
    FIFTH(5_000) {
        public String print(int count) {
            return "3개 일치 (5,000원) - " + count + "개";
        }
    },
    FOURTH(50_000) {
        public String print(int count) {
            return "4개 일치 (50,000원) - " + count + "개";
        }
    },
    THIRD(1_500_000) {
        public String print(int count) {
            return "5개 일치 (1,500,000원) - " + count + "개";
        }
    },
    SECOND(30_000_000) {
        public String print(int count) {
            return "5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개";
        }
    },
    FIRST(2_000_000_000) {
        public String print(int count) {
            return "6개 일치 (2,000,000,000원) - " + count + "개";
        }
    };

    private final int reword;

    WinningMoney(int reword) {
        this.reword = reword;
    }


    public int getReword() {
        return this.reword;
    }

    public abstract String print(int count);
}