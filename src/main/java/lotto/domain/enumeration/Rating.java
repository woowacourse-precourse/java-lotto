package lotto.domain.enumeration;

public enum Rating {

    NONE(0,0),
    FIFTH(3,5_000),
    FOURTH(4,50_000),
    THIRD(5,1_500_000),
    SECOND(5,30_000_000),
    FIRST(6,2_000_000_000);

    private final int accord;
    private final int prize;

    Rating(int accord, int prize) {
        this.accord = accord;
        this.prize = prize;
    }

    public static Rating checkTheRankings(int matchCount, boolean bonus){
        if(matchCount == Rating.SECOND.getAccord() && bonus) {
            return Rating.SECOND;
        }
        if(matchCount == Rating.FIRST.getAccord() && !bonus){
            return Rating.FIRST;
        }
        if(matchCount == Rating.THIRD.getAccord() && !bonus){
            return Rating.THIRD;
        }
        if(matchCount == Rating.FOURTH.getAccord() && !bonus){
            return Rating.FOURTH;
        }
        if(matchCount == Rating.FIFTH.getAccord() && !bonus){
            return Rating.FIFTH;
        }
        return Rating.NONE;
    }

    public int getAccord() {
        return accord;
    }

    public int getPrize() {
        return prize;
    }
}
