package data;

public enum PrizeData {
    FIFTH(5000, 3, 0, "5,000원"),
    FOURTH(50000, 4, 1, "50,000원"),
    THIRD(1500000, 5, 2, "1,500,000원"),
    SECOND(30000000, 5, 3, "30,000,000원"),
    FIRST(2000000000, 6, 4, "2,000,000,000원");

    private final int prizeMoney;
    private final int winningCount;
    private final int index;
    private final String prizeOutput;

    PrizeData(int prizeMoney, int winningCount, int index, String prizeOutput){
        this.prizeMoney = prizeMoney;
        this.winningCount = winningCount;
        this.index = index;
        this.prizeOutput = prizeOutput;
    }


    public int getIndex(){
        return index;
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

    public static int getWinningCount(int index){
        for(PrizeData data : PrizeData.values()){
            if(index == data.index){
                return data.winningCount;
            }
        }
        return -1;
    }

    public static String getPrizeOutput(int index){
        for(PrizeData data : PrizeData.values()){
            if(index == data.index){
                return data.prizeOutput;
            }
        }
        return "";
    }
}
