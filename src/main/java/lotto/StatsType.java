package lotto;

public enum StatsType {
    first(StatsConst.FIRST_SCORE,StatsConst.FIRST_MONEY),
    second(StatsConst.SECOND_SCORE,StatsConst.SECOND_MONEY),
    third(StatsConst.THIRD_SCORE,StatsConst.THIRD_MONEY),
    four(StatsConst.FOUR_SCORE,StatsConst.FOUR_MONEY),
    five(StatsConst.FIVE_SCORE,StatsConst.FIVE_MONEY);
    private final int score;
    private final int money;

    StatsType(int score,int money){
        this.score = score;
        this.money = money;
    }
    public int getScore(){return this.score;}
    public int getMoney(){return this.money;}
}
