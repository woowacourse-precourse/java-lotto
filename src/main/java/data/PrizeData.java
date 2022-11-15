package data;

public enum PrizeData {
    FIFTH(5000, 3, 0),
    FOURTH(50000, 4, 1),
    THIRD(1500000, 5, 2),
    SECOND(30000000, 5, 3),
    FIRST(2000000000, 6, 4);

    private final int prizeMoney;
    private final int winningCount;
    private final int index;

    PrizeData(int prizeMoney, int winningCount, int index){
        this.prizeMoney = prizeMoney;
        this.winningCount = winningCount;
        this.index = index;
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

    /**
     *
     * @param winningCount 당첨번호랑 일치 갯수
     * @param isHavingBonus 보너스 번호 보유 여부
     * @return
     */
    public static int matchWinningCountToPrize(int winningCount, boolean isHavingBonus){
        if(winningCount == SECOND.winningCount && isHavingBonus == true){ // 2등 검사
            return SECOND.index;
        }
        for(PrizeData data : PrizeData.values()){
            if(winningCount == data.winningCount){
                return data.index;
            }
        }
        return -1; // 없으면 통과
    }

    public static int getPrizeMoney(int index){
        for(PrizeData data : PrizeData.values()){
            if(index == data.index){
                return data.prizeMoney;
            }
        }
        return 0;
    }
}
