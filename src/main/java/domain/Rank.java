package domain;

public enum Rank {
    first(6,false,1),
    second(5,true,2),
    third(5,false,3),
    fourth(4,false,4),
    fifth(3, false, 5);

    public final int matchCount;
    public final boolean checkBonusNumber;
    public final int ranking;

    private Rank(int matchCount,boolean checkBonusNumber,int ranking){
        this.matchCount = matchCount;
        this.checkBonusNumber = checkBonusNumber;
        this.ranking = ranking;
    }
}
