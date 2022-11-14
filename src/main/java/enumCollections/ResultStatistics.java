package enumCollections;

public enum ResultStatistics {
    FIRST("6개 일치 (2,000,000,000원) - %d개\n"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    THIRD("5개 일치 (1,500,000원) - %d개\n"),
    FOURTH("4개 일치 (50,000원) - %d개\n"),
    FIFTH("3개 일치 (5,000원) - %d개\n"),
    YIELD("수익률은 %f%입니다."),
    GUIDE_MESSAGE("당첨 통계"),
    LINE("---");


    private String message;

    ResultStatistics(String message) {
        this.message = message;
    }

    public static String getMessage(ResultStatistics statistics) {
        return statistics.message;
    }
}
