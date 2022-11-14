package lotto;

public enum Winner {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    BONUS(50, 3000000),
    FIRST(6, 2000000000);

    private final int matchNumber;
    private final int prize;

    Winner(int matchNumber,int prize){
        this.matchNumber = matchNumber;
        this.prize = prize;
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
}
