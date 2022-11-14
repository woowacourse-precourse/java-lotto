package lotto.domain;

public enum Prize {
    NONE {
        void printPrizeStatistics(int count) {}
    },
    FIFTH{
        void printPrizeStatistics(int count) {
            System.out.println("3개 일치 (5,000원) - " + count + "개");
        }
    },
    FOURTH{
        void printPrizeStatistics(int count) {
            System.out.println("4개 일치 (50,000원) - " + count + "개");
        }
    },
    THIRD{
        void printPrizeStatistics(int count) {
            System.out.println("5개 일치 (1,500,000원) - " + count + "개");
        }
    },
    SECOND{
        void printPrizeStatistics(int count) {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
        }
    },
    FIRST {
        void printPrizeStatistics(int count) {
            System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");
        }
    },
    ;

    abstract void printPrizeStatistics(int count);
}
