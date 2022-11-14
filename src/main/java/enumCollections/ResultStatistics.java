package enumCollections;

public enum ResultStatistics {
    FIFTH("3개 일치 (5,000원) - %s개"),
    FOURTH("4개 일치 (50,000원) - %s개"),
    THIRD("5개 일치 (1,500,000원) - %s개"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개"),
    FIRST("6개 일치 (2,000,000,000원) - %s개"),
    YIELD("수익률은 %s%%입니다."),
    GUIDE_MESSAGE("당첨 통계"),
    LINE("---");


    private String message;

    ResultStatistics(String message) {
        this.message = message;
    }

    public static String getMessage(ResultStatistics rank) {
        return rank.message;
    }

    public static RankNumber getRankNumber(ResultStatistics rank) {
        return RankNumber.valueOf(rank.toString());
    }
}
