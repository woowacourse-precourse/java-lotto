package lotto.domain;

public enum WinningLotto {
    FIRST("2,000,000,000원"),
    SECOND("30,000,000원"),
    THIRD("1,500,000원"),
    FOURTH("50,000원"),
    FIFTH("5,000원");

    private String rank;

    WinningLotto(String rank) {
        this.rank = rank;
    }
}
