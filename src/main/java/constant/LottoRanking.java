package constant;

public enum LottoRanking {
    FIRST(1,6,2*(int)Math.pow(10,10)),SECOND(2,5,30000000),
    THIRD(3,5,1_500_000), FOURTH(4,4,50_000),
    FIFTH(5,3,5_000), NOTHING(-1,2,0);
    int value,sameNumberCount,price;
    LottoRanking(int ranking, int sameNumberCount, int price){
        this.value = ranking;
        this.sameNumberCount = sameNumberCount;
        this.price = price;
    }
    public int getRanking(){
        return value;
    }
    public int getSameNumberCount(){
        return sameNumberCount;
    }
    public int getPrice(){
        return price;
    }
}
