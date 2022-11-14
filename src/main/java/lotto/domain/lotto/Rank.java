package lotto.domain.lotto;

public enum Rank {
    FIRST("1등"), SECOND("2등"), THIRD("3등"), FOURTH("4등"), FIFTH("5등"), LOSE("미당첨"); // 1등, 2등, 3등, 4등, 5등, 미당청

    String name;

    Rank(String name) {
        this.name = name;
    }
}
