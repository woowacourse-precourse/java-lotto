package lotto.domain;

public enum Prize {
    NONE {
        void printPrizeStatistics(Integer count) {
        }
        Long calculateEachEarning(Integer count){
            return 0L;
        }
    },
    FIFTH{
        void printPrizeStatistics(Integer count) {
            System.out.println("3개 일치 (5,000원) - " + count + "개");
        }
        Long calculateEachEarning(Integer count){
            return 5000L * count;
        };
    },
    FOURTH{
        void printPrizeStatistics(Integer count) {
            System.out.println("4개 일치 (50,000원) - " + count + "개");
        }
        Long calculateEachEarning(Integer count){
            return 50_000L * count;
        };
    },
    THIRD{
        void printPrizeStatistics(Integer count) {
            System.out.println("5개 일치 (1,500,000원) - " + count + "개");
        }
        Long calculateEachEarning(Integer count){
            return 1_500_000L * count;
        };
    },
    SECOND{
        void printPrizeStatistics(Integer count) {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
        }
        Long calculateEachEarning(Integer count){
            return 30_000_000L * count;
        };
    },
    FIRST {
        void printPrizeStatistics(Integer count) {
            System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");
        }
        Long calculateEachEarning(Integer count){
            return 2_000_000_000L * count;
        };
    },
    ;

    abstract void printPrizeStatistics(Integer count);
    abstract Long calculateEachEarning(Integer count);
}
