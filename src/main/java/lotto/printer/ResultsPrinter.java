package lotto.printer;

public enum ResultsPrinter {

    BUYING_LOTTO_COUNT(-1) {
        @Override
        public void print(Number number) {
            System.out.println("\n" + number + "개를 구매했습니다.");
        }
    },

    THREE_MATCHES(5) {
        @Override
        public void print(Number number) {
            System.out.println("3개 일치 (5,000원) - " + number + "개");
        }
    },

    FOUR_MATCHES(4) {
        @Override
        public void print(Number number) {
            System.out.println("4개 일치 (50,000원) - " + number + "개");
        }
    },

    FIVE_MATCHES(3) {
        @Override
        public void print(Number number) {
            System.out.println("5개 일치 (1,500,000원) - " + number);
        }
    },

    FIVE_MATCHES_AND_BONUS_BALL(2) {
        @Override
        public void print(Number number) {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + number);
        }
    },

    SIX_MATCHES(1) {
        @Override
        public void print(Number number) {
            System.out.println("6개 일치 (2,000,000,000원) - " + number);
        }
    },

    NOT_THING(-1) {
        @Override
        public void print(Number number) {
            System.out.println("NOTHING" + number);
        }
    },

    GROSS_RETURN(-1) {
        @Override
        public void print(Number number) {
            System.out.println("총 수익률은 " + number + "%입니다.");
        }
    };

    final int ranking;

    ResultsPrinter(int ranking) {
        this.ranking = ranking;
    }

    public int getRanking() {
        return ranking;
    }

    public abstract void print(Number number);

}
