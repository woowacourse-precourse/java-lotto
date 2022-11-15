package lotto.constants;

public enum WinningStatistics {
    FIFTH("3개 일치 (5,000원) - %s개 "),
    FOURTH("4개 일치 (50,000원) - %s개"),
    THIRD("5개 일치 (1,500,000원) - %s개"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개"),
    FIRST("6개 일치 (2,000,000,000원) - %s개");

    private final String msg;

    WinningStatistics(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
