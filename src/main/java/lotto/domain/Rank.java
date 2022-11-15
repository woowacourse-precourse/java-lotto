package lotto.domain;

public enum Rank {
    RANK5(3, false, 5000, "3개 일치 (5,000원) - "),
    RANK4(4, false, 50000, "4개 일치 (50,000원) - "),
    RANK3(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    RANK2(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RANK1(6, false, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final boolean bonus;
    private final int reward;
    private final String resultText;

    private Rank(int matchCount, boolean bonus, int reward, String resultText){
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.reward = reward;
        this.resultText = resultText;
    }

    public int getMatchCount(){
        return this.matchCount;
    }

    public String getResultText(){
        return this.resultText;
    }

    public boolean getBonusCount(){
        return this.bonus;
    }

    public int getReward(){
        return this.reward;
    }
}
