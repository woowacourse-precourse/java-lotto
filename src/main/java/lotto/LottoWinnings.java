package lotto;

public enum LottoWinnings {
    LOTTO_1_WIN {
        public long money(int count) {
            return 2_000_000_000L * count;
        }
    },
    LOTTO_2_WIN {
        public long money(int count) {
            return 30_000_000L * count;
        }
    },
    LOTTO_3_WIN {
        public long money(int count) {
            return 1_500_000L * count;
        }
    },
    LOTTO_4_WIN {
        public long money(int count) {
            return 50_000L * count;
        }
    },
    LOTTO_5_WIN {
        public long money(int count) {
            return 5_000L * count;
        }
    };

    public abstract long money(int count);
}
