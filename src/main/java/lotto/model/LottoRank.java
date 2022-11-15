package lotto.model;

public enum LottoRank {

    THREE_CORRECT(3, BonusStatus.NO_MATTER, "3개 일치 (5,000원) - ", 5_000),
    FOUR_CORRECT(4, BonusStatus.NO_MATTER, "4개 일치 (50,000원) - ", 50_000),
    FIVE_CORRECT(5, BonusStatus.NOT_REQUIRED, "5개 일치 (1,500,000원) - ", 1_500_000),
    FIVE_PLUS_BONUS_CORRECT(5, BonusStatus.REQUIRED, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    SIX_CORRECT(6, BonusStatus.NO_MATTER, "6개 일치 (2,000,000,000원) - ", 2_000_000_000);

    private int correctCount;

    private BonusStatus bonusStatus;
    private String label;
    private int money;

    LottoRank(int correctCount, BonusStatus bonusStatus, String label, int money) {
        this.correctCount = correctCount;
        this.bonusStatus = bonusStatus;
        this.label = label;
        this.money = money;
    }

    public String getLabel() {
        return label;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public BonusStatus getBonusStatus() {
        return bonusStatus;
    }

    public int getMoney() {
        return money;
    }
}
