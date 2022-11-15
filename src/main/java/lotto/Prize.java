package lotto;

public enum Prize {
    FIRST( "0",6, false,2_000_000_000),
    SECOND("1",5, true,  30_000_000),
    THIRD("2",5, false,1_500_000),
    FOURTH("3",4, false,50_000),
    FIFTH("4",3, false, 5_000),
    FAIL("5",0,false, 0);
    private final String index;
    private final int sameAmount;
    private final boolean IsBonus;
    private final int reward;

    Prize(String index, int sameAmount, Boolean IsBonus, int reward) {
        this.index = index;
        this.sameAmount = sameAmount;
        this.IsBonus = IsBonus;
        this.reward = reward;
    }

    public String getIndex() { return index; }

    public int getSameAmount() { return sameAmount; }

    public int getReward() {
        return reward;
    }

    public static String valueOf(int sameAmount, boolean IsBonus) {
        if (sameAmount == 5 && IsBonus)
            return "1";
        if (sameAmount == 5 && !IsBonus)
            return "2";
        for (Prize prize : Prize.values())
            if (prize.sameAmount == sameAmount)
                return prize.getIndex();
        return "5";
    }

}
