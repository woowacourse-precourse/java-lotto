package lotto.Enum;

public enum Result {
    FIRST("6개 일치 (2,000,000,000원) - %d개"),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD("5개 일치 (1,500,000원) - %d개"),
    FOURTH("4개 일치 (50,000원) - %d개"),
    FIFTH("3개 일치 (5,000원) - %d개"),
    YIELD("총 수익률은 %.1f%%입니다.");

    private String result;
    Result(String result) {
        this.result = result;
    }
    public String getResult() {
        return result;
    }
}
