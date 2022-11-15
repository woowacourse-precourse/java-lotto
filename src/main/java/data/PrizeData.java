package data;

public enum PrizeData {
    FIFTH(5000, "5,000", 3, false),
    FOURTH(50000, "50,000", 4, false),
    THIRD(1500000, "1,500,000", 5, false),
    SECOND(30000000, "30,000,000", 5, true),
    FIRST(2000000000, "2,000,000,000", 6, false);

    private final int prizeMoney;
    private final String printingMoney;
    private final int winningCount;
    private final boolean isHavingBonus;

    PrizeData(int prizeMoney, String printingMoney, int winningCount, boolean isHavingBonus){
        this.prizeMoney = prizeMoney;
        this.printingMoney = printingMoney;
        this.winningCount = winningCount;
        this.isHavingBonus = isHavingBonus;
    }

    /**
     * 열거형에 등록된 상금 리턴
     * @return 상금
     */
    public int getPrizeMoney(){
        return prizeMoney;
    }


    /**
     * 당첨숫자랑 겹치는 갯수가 상금 조건과 일치하는지 확인
     * @param numberCount 당첨숫자와 겹치는 갯수
     * @return 겹치면 true, 아니면 false
     */
    public boolean isGettingPrize(int numberCount){
        return winningCount == numberCount;
    }
}
