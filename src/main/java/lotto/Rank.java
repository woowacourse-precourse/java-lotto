package lotto;

public enum Rank {
    FIRST("6개 일치 "),
    SECOND("5개 일치, 보너스 볼 일치 "),
    THIRD("5개 일치 "),
    FOURTH("4개 일치 "),
    FIFTH("3개 일치 ");

    private final String result;

    Rank(String result) {
        this.result = result;

    }

    public String getValue() {
        return result;
    }
}
