package lotto;

public enum Winner {
    FOURTH(3, 0,5000),
    THIRD(4, 1,50000),
    SECOND(5, 2,1500000),
    BONUS(50, 3,30000000),
    FIRST(6, 4,2000000000);

    private final int matchNumber;
    private final int statisticsIndex;
    private final int prize;

    Winner(int matchNumber,int statisticsIndex,int prize){
        this.matchNumber = matchNumber;
        this.statisticsIndex=statisticsIndex;
        this.prize = prize;
    }

    public static int[] getInfobyIndex(int statisticsIndex){
        int[] info= new int[2];
        for(Winner winner : Winner.values()){
            if(winner.statisticsIndex == statisticsIndex){
                info[0]=winner.matchNumber;
                info[1]=winner.prize;
                break;
            }
        }
        return  info;
    }
    public static int getPrize(int matchNumber){
        int retPrize=0;
        for(Winner winner : Winner.values()){
            if(winner.matchNumber==matchNumber){
                retPrize = winner.prize;
                break;
            }
        }
        return  retPrize;
    }

    public static int getStatisticsIndex(int matchNumber){
        for(Winner winner : Winner.values()){
            if(winner.matchNumber==matchNumber){
                return winner.statisticsIndex;
            }
        }
        return -1;
    }
}
