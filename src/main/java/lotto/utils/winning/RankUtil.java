package lotto.utils.winning;

public enum RankUtil {
    FIRST("6개 일치 (%,d원) - %d개"), // ex) String.format("%,d",1000000000) -> 1,000,000,000
    SECOND("5개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    THIRD("5개 일치 (%,d원) - %d개"),
    FOURTH("4개 일치 (%,d원) - %d개"),
    FIFTH("3개 일치 (%,d원) - %d개"),
    MISS("꽝");

    private final String message;

    RankUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
