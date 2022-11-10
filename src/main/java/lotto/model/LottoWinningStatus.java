package lotto.model;

public enum LottoWinningStatus {

    MATCH_SIX_NUMBERS(1, 2000000000L), MATCH_FIVE_NUMBERS_WITH_BONUS_NUMBER(2, 30000000L),
    MATCH_FIVE_NUMBERS(3, 1500000L), MATCH_FOUR_NUMBERS(4, 50000L), MATCH_THREE_NUMBERS(5, 5000L);

    private final Integer ranking;
    private final Long winningMoney;

    LottoWinningStatus(Integer ranking, Long winningMoney) {
        this.ranking = ranking;
        this.winningMoney = winningMoney;
    }

    public Integer getRanking() {
        return ranking;
    }

    public Long getWinningMoney() {
        return winningMoney;
    }
}
