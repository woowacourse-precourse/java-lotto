package lotto;

public enum Rank {
    first (2000000000),
    second (30000000) ,
    third (1500000) ,
    fourth (50000) ,
    fifth (5000)
    ;

    private final int rank;

    Rank(int rank) {
        this.rank = rank;
    }
    public int get_rank(){
        return rank;
    }

}
