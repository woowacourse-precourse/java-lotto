package lotto.view;

public enum Grade {
    FIRST(1, 6, 0,2_000_000_000),
    SECOND(2, 5, 1, 30_000_000),
    THIRD(3, 5,0, 1_500_000),
    FOURTH(4, 4, 0, 50_000),
    FIFTH(5, 3,0,5_000),
    NOTHING(6,0, 0, 0);
    final private int rank;
    final private int correctLotto;
    final private int correctBonus;
    final private int reward;

    public int getRank() {
        return rank;
    }

    public int getCorrectLotto() {
        return correctLotto;
    }

    public String getBonusMessage() {
        if (correctBonus == 1){
            return "보너스 볼 일치";
        }
        return "";
    }

    public int getReward() {
        return reward;
    }

    public String getRewardFormat() {
        String rewardFormat = Integer.toString(reward);
        rewardFormat = rewardFormat.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        return rewardFormat;
    }

    Grade(int rank, int correctLotto, int correctBonus, int reward) {
        this.rank = rank;
        this.correctLotto = correctLotto;
        this.correctBonus = correctBonus;
        this.reward = reward;
    }
}

