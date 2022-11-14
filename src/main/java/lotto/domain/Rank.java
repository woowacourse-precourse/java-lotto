package lotto.domain;

public enum Rank {

    FIRST(1,2000000000,6),
    SECOND(2,30000000,5),
    THIRD(3,1500000,5),
    FOURTH(4,50000,4),
    FIFTH(5,5000,3),
    LOST(0,0,0);

    private final int rank;
    private final int value;
    private final int count;

    Rank(int rank,int value,int count){
        this.rank=rank;
        this.value=value;
        this.count=count;
    }
    public int getRank(){
        return rank;
    }
    public int getValue(){
        return value;
    }
    public int getCount(){
        return count;
    }
    public static Rank getRank(int count,boolean containsBonus){
        if(count== SECOND.getCount()&&containsBonus){
            return SECOND;
        }
        for(Rank rank:Rank.values()){
                if(count==rank.getCount()){
                    return rank;
                }
        }
        return LOST;
    }
}
