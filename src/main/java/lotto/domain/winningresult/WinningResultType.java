package lotto.domain.winningresult;

public enum WinningResultType {
    FIFTH_PLACE("3개 일치", 5_000),
    FOURTH_PLACE("4개 일치", 50_000),
    THIRD_PLACE("5개 일치", 1_500_000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", 30_000_000),
    FIRST_PLACE("6개 일치", 2_000_000_000);

    private String content;
    private int reward;

    WinningResultType(String content, int reward) {
        this.content = content;
        this.reward = reward;
    }
}
