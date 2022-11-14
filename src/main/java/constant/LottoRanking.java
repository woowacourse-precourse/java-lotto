package constant;

public enum LottoRanking {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5);
    int value;
    LottoRanking(int rankingValue){
        this.value = rankingValue;
    }
    public int getRanking(){
        return value;
    }
}
